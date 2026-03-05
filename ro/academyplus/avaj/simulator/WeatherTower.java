package ro.academyplus.avaj.simulator;

public class WeatherTower extends Tower{
    // return coordinates of a specific case
    public String getWeather(Coordinates p_coords) {
        return WeatherProvider.getProvider().getCurrentWeather(p_coords);
    }

    // Simulation trigger. Calls the method that notifies all aircraft that the weather has changed.
    public void changeWeather(){
        this.conditionChanged();
    } 
}
