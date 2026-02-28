package ro.academyplus.avaj.simulator;

// Heredamos de Exception para que Java la reconozca como un error
public class InvalidScenarioException extends Exception {
    
    public InvalidScenarioException(String mensaje) {
        super(mensaje);
    }
}