public class AircraftFactory {
    private static long id_counter = 0;
    private static AircraftFactory instance;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        id_counter++;
        if (p_type.equals("Helicopter")) {
            return new Helicopter(id_counter, p_name, p_coordinates);
        }
        else if (p_type.equals("Baloon")) {
            return new Baloon(id_counter, p_name, p_coordinates);
        }
        else {
            return new JetPlane(id_counter, p_name, p_coordinates);
        }
        // METER EXCEPCIONES PARA SI NO ES UNA DE LAS TRES
    }

    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }
}
