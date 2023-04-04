package main.java.com.dev.course.model.response;

public class CurrentWeather {
    private String temperature;
    private String location;
    private String humidity;

    public CurrentWeather(String temperature, String location, String humidity) {
        this.temperature = temperature;
        this.location = location;
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}
