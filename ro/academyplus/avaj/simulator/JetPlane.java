package ro.academyplus.avaj.simulator;

public class JetPlane extends Aircraft{
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates); 
    }

    public String getType() {
        return "JetPlane";
    }

    public void registerTower(WeatherTower p_tower) {
        super.registerTower(p_tower); // Esto ejecuta el código de Aircraft que guarda la torre
    }
    
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equals("SUN")) {
            this.coordinates.updateLatitude(10);
            this.coordinates.updateHeight(2);
            Logger.log("JetPlane#" + this.getName() + "(" + this.getId() +"): Horny horny!");
        }

        if (weather.equals("RAIN")) {
            this.coordinates.updateLatitude(5);
            Logger.log("JetPlane#" + this.getName() + "(" + this.getId() +"): Just having a bath!");
        }

        if (weather.equals("FOG")) {
            this.coordinates.updateLatitude(1);
            Logger.log("JetPlane#" + this.getName() + "(" + this.getId() +"): Flyng without eyes");
        }

        if (weather.equals("SNOW")) {
            this.coordinates.updateHeight(-7);
            Logger.log("JetPlane#" + this.getName() + "(" + this.getId() +"): I would like to land and make a snowman");
        }
        
        if (this.coordinates.getHeight() <= 0) {
            // quito de registro
            Logger.log("JetPlane#" + this.getName() + "(" + this.getId() +"): landing!");
            weatherTower.unregister(this);
        }
    }
}
