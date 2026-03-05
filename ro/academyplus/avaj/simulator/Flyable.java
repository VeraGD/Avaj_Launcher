package ro.academyplus.avaj.simulator;

public interface Flyable {

    // What does the plane make with its new wetaher
    public abstract void updateConditions();

    // save the tower reference
    public abstract void registerTower(WeatherTower p_tower);
}
