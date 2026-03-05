package ro.academyplus.avaj.simulator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Logger {
    private static PrintWriter writer;

    public static void init(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.out.println("Error creating the file: " + e.getMessage());
        }
    }

    // write on the file
    public static void log(String message) {
        if (writer != null) {
            writer.println(message);
        }
    }

    // save changes
    public static void close() {
        if (writer != null) {
            writer.close();
        }
    }
}