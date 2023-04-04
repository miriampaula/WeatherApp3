package main.java.com.dev.course.weather.provider;

import main.java.com.dev.course.http.SimpleHttpClient;
import main.java.com.dev.course.model.request.WeatherByCityApiRequest;
import main.java.com.dev.course.model.request.WeatherByCoordinatesApiRequest;
import main.java.com.dev.course.model.response.CurrentWeather;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeatherProvider {
    private SimpleHttpClient simpleHttpClient;
    private Map<String, CurrentWeather> weatherCache = new HashMap<>();

    public CurrentWeather provideForCity(WeatherByCityApiRequest weatherByCityApiRequest){
        //TODO: this needs a logic to interogate the cache if it has values for city otherwise get from external api
        return new CurrentWeather(String.valueOf(new Random().nextInt(20)), weatherByCityApiRequest.getCity(), "20%");
    }

    public CurrentWeather provideForCoordinates(WeatherByCoordinatesApiRequest weatherByCoordinatesApiRequest){
        //TODO: this needs a logic to interogate the cache if it has values for city otherwise get from external api
        return new CurrentWeather(String.valueOf(new Random().nextInt(20)), weatherByCoordinatesApiRequest.getLatitude() + " " + weatherByCoordinatesApiRequest.getLongitude(), "20%");

    }
}
