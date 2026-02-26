public class WeatherProvider {
    private String weather;

    private WeatherProvider(){
        this.weather = "SUN";

    }

    public String getCurrentWeather(Coordinates coords) {
        int result = (coords.getLongitude() + coords.getLatitude() + coords.getHeight()) % 4;
        String[] weathers = {"SNOW", "SUN", "RAIN", "FOG"};
        this.weather =  weathers[result];
        return weather;
    }
}
