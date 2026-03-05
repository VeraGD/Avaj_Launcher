package ro.academyplus.avaj.simulator;

public class Simulator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Simulator [scenario_file]");
            return;
        }

        try {
            // Init parse
            ParseInput parser = new ParseInput();
            parser.parseFile(args[0]);

            // Create tower and register all aircrafts
            WeatherTower weatherTower = new WeatherTower();
            for (Flyable f : parser.getAircrafts()) {
                f.registerTower(weatherTower);
            }

            // Parsing and simulation
            Logger.init("simulation.txt");
            for (int i = 0; i < parser.getCycles(); i++) {
                weatherTower.changeWeather();
            }
            Logger.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}