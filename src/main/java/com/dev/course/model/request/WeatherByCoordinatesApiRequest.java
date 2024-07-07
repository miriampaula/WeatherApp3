package main.java.com.dev.course.model.request;


public class WeatherByCoordinatesApiRequest implements ApiRequest {
    private String latitude;
    private String longitude;

    public WeatherByCoordinatesApiRequest(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
