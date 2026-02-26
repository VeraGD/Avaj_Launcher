public class Helicopter extends Aircraft{
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates); // porque es protected en Aircraft
    }

    public void updateConditions() {
        // consultar clima: le pide a la torre el clima de su posicion actual
        // moverse: segun clima y reglas del enunciado, actualiza sus coords
        // gritar: escribe un mensaje gracioso segun el clima
        // aterrizar: si al moverse llega a <= 0 le dicen a la torre que se desvincula por aterrizaje
        
    }

}
