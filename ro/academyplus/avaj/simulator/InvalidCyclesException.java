package ro.academyplus.avaj.simulator;

public class InvalidCyclesException extends InvalidScenarioException {

    public InvalidCyclesException() {
        super("Invalid number of cycles, it must be a positive integer");
    }
}