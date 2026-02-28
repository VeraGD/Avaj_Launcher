package ro.academyplus.avaj.simulator;

public class Balloon extends Aircraft{
    public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates); 
    }

    public String getType() {
        return "Balloon";
    }
    
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates.updateLongitude(2);
            this.coordinates.updateHeight(4);
            Logger.log("Balloon#" + this.getName() + "(" + this.getId() +"): Enjoying sauna!");
        }

        if (weather.equals("RAIN")) {
            this.coordinates.updateHeight(-5);
            Logger.log("Balloon#" + this.getName() + "(" + this.getId() +"): MMM fresh water Baby!");
        }

        if (weather.equals("FOG")) {
            this.coordinates.updateHeight(-3);
            Logger.log("Balloon#" + this.getName() + "(" + this.getId() +"): Who is smoking?");
        }

        if (weather.equals("SNOW")) {
            this.coordinates.updateHeight(-15);
            Logger.log("Balloon#" + this.getName() + "(" + this.getId() +"): I'm changing myself into white");
        }

        if (this.coordinates.getHeight() <= 0) {
            Logger.log("Balloon#" + this.getName() + "(" + this.getId() +"): landing!");
            weatherTower.unregister(this);
        }
    }
}
