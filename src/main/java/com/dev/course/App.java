package main.java.com.dev.course;

import main.java.com.dev.course.controller.ApiController;
import main.java.com.dev.course.handler.ApiRequestHandler;
import main.java.com.dev.course.handler.WeatherByCityRequestHandler;
import main.java.com.dev.course.model.request.ApiRequest;
import main.java.com.dev.course.model.request.WeatherByCityApiRequest;
import main.java.com.dev.course.model.request.WeatherByCoordinatesApiRequest;
import org.eclipse.jetty.http.HttpStatus;

import java.sql.SQLException;


public class App {
	public static void main(String[] args) throws SQLException {
		ApiController apiController = new ApiController();
		apiController.startSparkHttpServer();
	}
}
