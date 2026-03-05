package ro.academyplus.avaj.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseInput {
    private int cycles;
    private List<Flyable> aircrafts = new ArrayList<>();

    public void parseFile(String fileName) throws IOException, InvalidScenarioException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // First line, circles
            String firstLine = br.readLine();
            if (firstLine == null) throw new InvalidScenarioException("Empty file");
            try {
                this.cycles = Integer.parseInt(firstLine);
                if (this.cycles < 0) throw new InvalidCyclesException();
            } catch (NumberFormatException e) {
                throw new InvalidCyclesException();
            }

            // rest of the file, aircrafts
            String line;
            int lineNum = 2;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines
                aircrafts.add(parseAircraftLine(line, lineNum++));
            }
        }
    }

    private Flyable parseAircraftLine(String line, int lineNum) throws InvalidScenarioException {
        String[] parts = line.split("\\s+"); // More han one space
        if (parts.length != 5) 
            throw new InvalidScenarioException("Incorrect format on the line " + lineNum);

        try {
            // 5 parts, type name latitude longitude hight
            String type = parts[0];
            String name = parts[1];
            int lon = Integer.parseInt(parts[2]);
            int lat = Integer.parseInt(parts[3]);
            int height = Integer.parseInt(parts[4]);

            if (lon < 0 || lat < 0 || height < 0)
                throw new NotPositiveNumericException(lineNum);

            // Create the new aircraft
            Flyable f = AircraftFactory.getInstance().newAircraft(type, name, new Coordinates(lon, lat, height));
            if (f == null) throw new UnknownAircraftTypeException(type);
            
            return f;
        } catch (NumberFormatException e) {
            throw new NotPositiveNumericException(lineNum);
        }
    }

    public int getCycles() {
        return cycles;
    }

    public List<Flyable> getAircrafts() {
        return aircrafts;
    }
}