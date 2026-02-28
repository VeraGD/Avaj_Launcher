package ro.academyplus.avaj.simulator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Logger {
    private static PrintWriter writer;

    // Se llama una sola vez al principio del Simulator
    public static void init(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    // El método que usarás en todo el proyecto
    public static void log(String message) {
        if (writer != null) {
            writer.println(message);
        }
    }

    // Se llama al final del Simulator para guardar los cambios
    public static void close() {
        if (writer != null) {
            writer.close();
        }
    }
}