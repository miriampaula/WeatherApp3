package main.java.com.dev.course.handler;

import main.java.com.dev.course.converter.CurrentWeatherToJsonConverter;
import main.java.com.dev.course.model.request.ApiRequest;
import main.java.com.dev.course.model.request.WeatherByCityApiRequest;

public class WeatherByCityHandler extends WeatherRequestHandler{
    private final CurrentWeatherToJsonConverter converter = new CurrentWeatherToJsonConverter();
    @Override
    public String handle(ApiRequest request) {
        return converter.convertCurrentWeatherToJson(getWeatherProvider().provideForCity((WeatherByCityApiRequest) request));
    }
}
