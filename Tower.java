import java.util.List;

// la fecla vacia es herencia -> extends
// el rombo es que contiene una lista

public class Tower extends WeatherTower{
    private List<Flyable> observers; // con *

    public void register(Flyable p_flyable) { // con *
        observers.add(p_flyable);
        // resgistra avion en su lista de vigilancia para avisarle de cosas
        // datos de flyable
        System.out.println("Tower says: Balloon#" + p_flyable.getName() + "(" + p_flyable.getId() +") registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) { // con *
        miLista.remove(p_flyable.getId() + 1);
        // elimina avión de esa lista
        System.out.println("Tower says: Balloon#" + p_flyable.getName() + "(" + p_flyable.getId() +") unregistered from weather tower.");
    }

    protected void conditionChanged() {
        // recorre la lista y avisa a los aviones si algo ha cambiado en el cielo
        System.out.println("Tal avion ha subido/bajado o se ha pasado a SUN");
    }
}
