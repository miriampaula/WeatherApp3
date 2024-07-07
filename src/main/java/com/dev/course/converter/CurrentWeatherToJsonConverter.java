package main.java.com.dev.course.converter;

import main.java.com.dev.course.model.response.CurrentWeather;

public class CurrentWeatherToJsonConverter {
    public String convertCurrentWeatherToJson(CurrentWeather currentWeather){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        stringBuilder.append("\"temperature\":")
                .append("\"")
                .append(currentWeather.getTemperature())
                .append("\"\n}");
        return stringBuilder.toString();
    }

}
