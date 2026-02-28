package ro.academyplus.avaj.simulator; // <-- 1. Declaración obligatoria

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Bad number of args");
            return;
        }

        String fileName = args[0];

        WeatherTower weatherTower = new WeatherTower();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String primeraLinea = br.readLine();
            int repeticiones = 0;

            if (primeraLinea != null) {
                    repeticiones = Integer.parseInt(primeraLinea);
                    // Si no es un numero me lamza un numberformat expresion, que es el que tomo abajo
                    // System.out.println("La simulación se ejecutará " + repeticiones + " veces.");
            }

            String lineaAeronave;

            while ((lineaAeronave = br.readLine()) != null) {
                    
                //System.out.println("He detectado una aeronave: " + lineaAeronave);

                String[] datos = lineaAeronave.split(" ");

                if (datos.length != 5) {
                    throw new InvalidScenarioException("Incorrect form in the line: " + lineaAeronave);
                }

                String p_tipo = datos[0];
                int flag = 0;

                String[] types = {"Helicopter", "Balloon", "JetPlane"};

                for (int i = 0; i < types.length; i++ ) {
                    if (types[i].equals(p_tipo)) {
                        flag = 1;
                    }
                }

                if (flag != 1) {
                    throw new InvalidScenarioException("Incorrect form in the line: " + lineaAeronave);
                }

                String p_nombre = datos[1];

                try {
                    int p_longitude = Integer.parseInt(datos[2]);
                    int p_latitude = Integer.parseInt(datos[3]);
                    int p_height = Integer.parseInt(datos[4]);
                    
                    // Regla del proyecto: las coordenadas son números positivos
                    if (p_longitude < 0 || p_latitude < 0 || p_height < 0) {
                        throw new InvalidScenarioException("Las coordenadas no pueden ser negativas: " + lineaAeronave);
                    }
        
                    //System.out.println("Avión válido: " + p_tipo + " " + p_nombre);

                    Coordinates p_coords = new Coordinates(p_longitude, p_latitude, p_height);

                    Flyable newPlane = AircraftFactory.getInstance().newAircraft(p_tipo, p_nombre, p_coords);
                    
                    if (newPlane != null) {
                        newPlane.registerTower(weatherTower);
                    } else {
                        throw new InvalidScenarioException("Tipo de aeronave desconocido: " + p_tipo);
                    }

                } catch (NumberFormatException e) {
                    throw new InvalidScenarioException("Las coordenadas deben ser números enteros.");
                }
            }

            int i = 0;
            Logger.init("simulation.txt");

            while (i < repeticiones) {
                weatherTower.changeWeather();
                i++;
            }
            Logger.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: La primera línea no es un número válido.");
        } catch (InvalidScenarioException e) {
            System.out.println("Error de validación del escenario: " + e.getMessage());
        }
    }
        // 1. Validar que nos han pasado e

    // leo el numero de ciclos
    // leo lineas de aviones y uso Factory para crearlos
    // registro los aviones en weathertower
    // empieza bucle:
        // x veces se llana a change weather cada avion se actualiza,
        // se mueve, grita mensaje, y si toca suelo, aterriza y desaparece
}
