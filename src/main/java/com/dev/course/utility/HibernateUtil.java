package main.java.com.dev.course.utility;

import java.sql.SQLException;
import java.util.Properties;

import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import main.java.com.dev.course.entity.Location;

public class HibernateUtil {

    // Property based configuration
    private static SessionFactory sessionJavaConfigFactory;

    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
            Configuration configuration = new Configuration();

            // Create Properties, can be read from property files too
            Properties props = new Properties();
            props.put("hibernate.connection.driver_class", "org.h2.Driver");
            props.put("hibernate.connection.url",
                    "jdbc:h2:file:./db/demo;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
            props.put("hibernate.connection.username", "sa");
            props.put("hibernate.connection.password", "");
            props.put("hibernate.current_session_context_class", "thread");
            props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            props.put("hibernate.hbm2ddl.auto", "update");
            props.put("hibernate.connection.autocommit", "true");
            props.put("hibernate.id.new_generator_mappings", "true");

            configuration.setProperties(props);

            // we can set mapping file or class with annotation
            configuration.addAnnotatedClass(Location.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            return sessionFactory;
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionJavaConfigFactory() {
        if (sessionJavaConfigFactory == null)
            sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }

    public static void startDBServer() throws SQLException {
        Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
    }

    public static void stopDBServer() throws SQLException {
        Server.shutdownTcpServer("tcp://localhost:9092", "", true, true);
    }

}
