package main.java.com.dev.course.handler;

import main.java.com.dev.course.model.request.ApiRequest;
import main.java.com.dev.course.model.request.WeatherByCityApiRequest;

public class WeatherByCityRequestHandler extends ApiRequestHandler {
    @Override
    public String handleWeatherRequest(ApiRequest apiRequest) {
        return converter.convertCurrentWeatherToJson(getWeatherProvider().provideWeatherByCity((WeatherByCityApiRequest) apiRequest));
    }
}
