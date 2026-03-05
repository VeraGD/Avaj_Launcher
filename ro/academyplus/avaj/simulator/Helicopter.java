package ro.academyplus.avaj.simulator;

public class Helicopter extends Aircraft{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates); // protected
    }

    public String getType() {
        return "Helicopter";
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates.updateLongitude(10);
            this.coordinates.updateHeight(2);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): Too hot and spicy for meee!");
        } else if (weather.equals("RAIN")) {
            this.coordinates.updateLongitude(5);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): Singing in the shower!");
        } else if (weather.equals("FOG")) {
            this.coordinates.updateLongitude(1);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): I don't see anything, Can someone clean the window?");
        } else if (weather.equals("SNOW")) {
            this.coordinates.updateHeight(-12);
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): Frozen world! Let it go!");
        }

        if (this.coordinates.getHeight() <= 0) {
            // quito de registro
            Logger.log("Helicopter#" + this.getName() + "(" + this.getId() +"): landing!");
            weatherTower.unregister(this);
        }
    }

}
