package ro.academyplus.avaj.simulator;

public class NotPositiveNumericException extends InvalidScenarioException {

    public NotPositiveNumericException(int numline) {
        super("Invalid number in Coordinates, they must be positives numbers. Line: " + numline);
    }
}