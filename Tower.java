import java.util.List;

// la fecla vacia es herencia -> extends
// el rombo es que contiene una lista

public class Tower extends WeatherTower{
    private List<Flyable> observers; // con *

    public void register(Flyable p_flyable) { // con *
        // resgistra avion en su lista de vigilancia para avisarle de cosas
        System.out.println("Tal avion despega");
    }

    public void unregister(Flyable p_flyable) { // con *
        // elimina avión de esa lista
        System.out.println("Tal avion aterrizo");
    }

    protected void conditionChanged() {
        // recorre la lista y avisa a los aviones si algo ha cambiado en el cielo
        System.out.println("Tal avion ha subido/bajado o se ha pasado a SUN");
    }
}
