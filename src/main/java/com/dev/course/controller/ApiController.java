package main.java.com.dev.course.controller;

import main.java.com.dev.course.handler.WeatherByCityHandler;
import main.java.com.dev.course.handler.WeatherByCoordinatesHandler;
import main.java.com.dev.course.handler.WeatherRequestHandler;
import main.java.com.dev.course.model.request.WeatherByCityApiRequest;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.get;

public class ApiController {
    public void startServerAndExposeEndpoints(){
        get("/api/v1/weather/cities/city/:city", (request, response) -> {
            WeatherRequestHandler weatherByCityHandler = new WeatherByCityHandler();
            response.type("application/json");
            response.status(HttpStatus.OK_200);
            return weatherByCityHandler.handle(new WeatherByCityApiRequest(request.params(":city")));
        });

        get("/api/v1/weather/lat/:lat/long/:long", (request, response) -> {
            WeatherRequestHandler weatherByCoordinatesHandler = new WeatherByCoordinatesHandler();
            response.type("application/json");
            response.status(HttpStatus.OK_200);
            String city = request.params(":lat");
            return city;
        });
    }
}
