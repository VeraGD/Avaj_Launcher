package ro.academyplus.avaj.simulator;

public class Helicopter extends Aircraft{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates); // porque es protected en Aircraft
    }

    public String getType() {
        return "Helicopter";
    }

    public void registerTower(WeatherTower p_tower) {
        super.registerTower(p_tower); // Esto ejecuta el código de Aircraft que guarda la torre
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates.updateLongitude(10);
            this.coordinates.updateHeight(2);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): Too hot and spicy for meee!");
        }

        if (weather.equals("RAIN")) {
            this.coordinates.updateLongitude(5);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): Singing in the shower!");
        }

        if (weather.equals("FOG")) {
            this.coordinates.updateLongitude(1);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): I don't see anything, Can someone clean the window?");
        }

        if (weather.equals("SNOW")) {
            this.coordinates.updateHeight(-12);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): Frozen worl! Let it go!");
        }
        // consultar clima: le pide a la torre el clima de su posicion actual
        // moverse: segun clima y reglas del enunciado, actualiza sus coords
        // gritar: escribe un mensaje gracioso segun el clima
        // aterrizar: si al moverse llega a <= 0 le dicen a la torre que se desvincula por aterrizaje
        if (this.coordinates.getHeight() <= 0) {
            // quito de registro
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): landing!");
            weatherTower.unregister(this);
        }
    }

}
