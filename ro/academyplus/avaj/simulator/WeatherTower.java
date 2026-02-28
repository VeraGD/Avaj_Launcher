package ro.academyplus.avaj.simulator;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates p_coords) {
        return WeatherProvider.getProvider().getCurrentWeather(p_coords);
        // pregunta a weatherprovider que clima hay eb unas coordenadas
        // especificadas y devuelve el resultado
    }

    public void changeWeather(){
        this.conditionChanged();
            // Disparador de la simulacion. llama al metodo que avisa a
            // todos los aviones que el clima ha cambiado
    } 
}
