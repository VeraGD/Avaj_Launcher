package ro.academyplus.avaj.simulator;

public class UnknownAircraftTypeException extends InvalidScenarioException {

    public UnknownAircraftTypeException(String type) {
        super("Unknown aircraft type: " + type);
    }
}