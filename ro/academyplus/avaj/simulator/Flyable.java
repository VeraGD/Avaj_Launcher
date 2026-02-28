package ro.academyplus.avaj.simulator;

public interface Flyable {

    public abstract void updateConditions();
    // que hace el avion cuando cambia el tiempo
    public abstract void registerTower(WeatherTower p_tower); // con * y sin atributo
    // guarda la referencia a la torre para comunicarse
}
