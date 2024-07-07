package main.java.com.dev.course.controller;

import main.java.com.dev.course.handler.ApiRequestHandler;
import main.java.com.dev.course.handler.WeatherByCityRequestHandler;
import main.java.com.dev.course.model.request.ApiRequest;
import main.java.com.dev.course.model.request.WeatherByCityApiRequest;
import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.get;

public class ApiController {
    static ApiRequestHandler apiRequestHandler = new WeatherByCityRequestHandler();

    public void startSparkHttpServer(){
        get("/api/v1/weather/cities/city/:city", (request, response) -> {
            String city = request.params(":city");
            ApiRequest apiRequest = new WeatherByCityApiRequest(city);
            response.type("application/json");
            response.status(HttpStatus.OK_200);

            return apiRequestHandler.handleWeatherRequest(apiRequest);
        });
    }
}
