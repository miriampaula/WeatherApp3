package com.dev.course;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.course.route.ApiRoute;
import com.dev.course.spark.SparkContext;
import com.dev.course.spark.SparkContextConfig;

public class AppBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(AppBootstrap.class);

    public static void main(String... args) {

        logger.info("App started...");

        final SparkContext context = createSparkContext();

        // Comment out any of this entries to disable the respective routes.
        context.addRouteBuilder(new ApiRoute());
    }

    private static SparkContext createSparkContext() {

        final SparkContextConfig config = new SparkContextConfig(8081, "/api");
        config.threadPool(8);

        final SparkContext context = new SparkContext(config);

        context.enableLogLevelPerRequest();
        context.enableCorrelationId();
        context.enableErrorHandler();
        context.enableCors();
        context.enableCorsPreflight();
        context.logHttpRequest();
        context.logHttpRequestBody();
        context.defaultContentType("application/json");

        return context;
    }
}
