package ro.academyplus.avaj.simulator;

public abstract class Aircraft implements Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherTower weatherTower;

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;    // Tower registered by the plane
        this.weatherTower.register(this); // tower register the plane
    }

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    protected long getId() {
        return this.id;
    }

    protected String getName() {
        return this.name;
    }
}
