package main.java.com.dev.course;

import static spark.Spark.get;
import static spark.Spark.post;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.eclipse.jetty.http.HttpStatus;
import org.hibernate.Session;

import com.google.gson.Gson;

import main.java.com.dev.course.entity.Location;
import main.java.com.dev.course.utility.HibernateUtil;

public class App {
	public static void main(String[] args) throws SQLException {

		// start H2 Server
		HibernateUtil.startDBServer();

		get("/location", (request, response) -> {

			response.type("application/json");
			response.status(HttpStatus.OK_200);

			Session currentSession = HibernateUtil.getSessionJavaConfigFactory().getCurrentSession();
			currentSession.beginTransaction();
			List<Location> resultList = currentSession.createQuery("SELECT a FROM Location a", Location.class)
					.getResultList();
			currentSession.getTransaction().commit();
			return new Gson().toJson(resultList);
		});

		post("/location", (request, response) -> {
			response.type("application/json");
			response.status(HttpStatus.CREATED_201);

			Location location = new Gson().fromJson(request.body(), Location.class);

			Session currentSession = HibernateUtil.getSessionJavaConfigFactory().getCurrentSession();
			currentSession.beginTransaction();
			Serializable id = currentSession.save(location);
			currentSession.getTransaction().commit();
			location.setId(Integer.parseInt(id.toString()));

			return new Gson().toJson(location);
		});
	}
}
