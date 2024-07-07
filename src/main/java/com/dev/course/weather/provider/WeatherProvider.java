package main.java.com.dev.course.weather.provider;

import main.java.com.dev.course.model.request.WeatherByCityApiRequest;
import main.java.com.dev.course.model.response.CurrentWeather;

import java.util.Random;

public class WeatherProvider {
    public CurrentWeather provideWeatherByCity(WeatherByCityApiRequest weatherByCityApiRequest){
        return new CurrentWeather(new Random().nextInt(50),"whatever");
    }
    public CurrentWeather provideWeatherByCoordinates(){
return null;
    }
}
