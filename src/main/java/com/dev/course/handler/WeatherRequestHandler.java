package main.java.com.dev.course.handler;

import main.java.com.dev.course.weather.provider.WeatherProvider;
import main.java.com.dev.course.model.request.ApiRequest;

public abstract class WeatherRequestHandler {
    protected WeatherProvider weatherProvider = new WeatherProvider();

    public abstract String handle(ApiRequest request);

    public WeatherProvider getWeatherProvider() {
        return weatherProvider;
    }
}
