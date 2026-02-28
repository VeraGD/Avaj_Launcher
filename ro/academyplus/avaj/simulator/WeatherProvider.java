package ro.academyplus.avaj.simulator;

public class WeatherProvider {
    private String weather;
    private static WeatherProvider instance;

    private WeatherProvider() {}

     public static WeatherProvider getProvider() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coords) {
        int result = (coords.getLongitude() + coords.getLatitude() + coords.getHeight()) % 4;
        String[] weathers = {"SNOW", "SUN", "RAIN", "FOG"};
        this.weather =  weathers[result];
        return weather;
    }
}
