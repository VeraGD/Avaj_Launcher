package ro.academyplus.avaj.simulator;

import java.util.ArrayList;
import java.util.List;

// la fecla vacia es herencia -> extends
// el rombo es que contiene una lista

public class Tower {
    private List<Flyable> observers = new ArrayList<>(); // con *

    public void register(Flyable p_flyable) { // con *
        observers.add(p_flyable);

        Aircraft p_aircraft = (Aircraft) p_flyable;
    
        Logger.log("Tower says: Balloon#" + p_aircraft.getName() + "(" + p_aircraft.getId() +") registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) { // con *
        observers.remove(p_flyable);

        Aircraft p_aircraft = (Aircraft) p_flyable;

        Logger.log("Tower says: " + p_flyable.getClass().getSimpleName() + "#" + p_aircraft.getName() + "(" + p_aircraft.getId() +") unregistered from weather tower.");
    }

    protected void conditionChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}
