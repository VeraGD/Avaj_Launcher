public class WeatherTower {
    public String getWeather(Coordinates p_coords) {
        return getCurrentWeather(p_coords);
        // pregunta a weatherprovider que clima hay eb unas coordenadas
        // especificadas y devuelve el resultado
    }

    public void changeWeather(){
            // Disparador de la simulacion. llama al metodo que avisa a
            // todos los aviones que el clima ha cambiado
    } 
}
