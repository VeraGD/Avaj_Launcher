// rombo relleno es que es hijo de, es decir, este es el padre de Coordinates
// por lo que hay que hacer new de coordinates

public abstract class Aircraft implements Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherTower weathertower; // aqui porque es hijo

    public void resgisterTower(WeatherTower p_tower) {
        this.weathertower = p_tower; // hola
        //p_tower.register(this);
        // aqui, recibo torre, guardo referencia en weatertower interno
        // se registrar llamando a register(this) y dice hola soy tal avion, añademe
    }

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    private long getId() {
        return this.id;
    }

    private String getName() {
        return this.name;
    }
}
