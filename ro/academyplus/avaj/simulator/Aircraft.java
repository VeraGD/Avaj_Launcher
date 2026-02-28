package ro.academyplus.avaj.simulator;
// rombo relleno es que es hijo de, es decir, este es el padre de Coordinates
// por lo que hay que hacer new de coordinates

public abstract class Aircraft implements Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherTower weatherTower; // aqui porque es hijo

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;    // 1. EL AVIÓN GUARDA LA TORRE (Vital)
        this.weatherTower.register(this); // 2. LA TORRE GUARDA AL AVIÓN
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
