package main.java.com.dev.course.handler;

import main.java.com.dev.course.converter.CurrentWeatherToJsonConverter;
import main.java.com.dev.course.weather.provider.WeatherProvider;
import main.java.com.dev.course.model.request.ApiRequest;

public abstract class ApiRequestHandler {
    private WeatherProvider weatherProvider = new WeatherProvider();
    protected CurrentWeatherToJsonConverter converter = new CurrentWeatherToJsonConverter();

    public WeatherProvider getWeatherProvider() {
        return weatherProvider;
    }

    public abstract String handleWeatherRequest(ApiRequest apiRequest);
}
