package main.java.com.dev.course.model.response;

import java.math.BigDecimal;

public class CurrentWeather {
    private int temperature;
    private String humidity;

    public CurrentWeather(int temperature, String humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
