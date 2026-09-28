# ✈️ AVAJ-Launcher

> **AVAJ-Launcher** is an aircraft simulation application developed as part of the 42 School curriculum. The project simulates different types of aircraft interacting with changing weather conditions over a series of simulation loops.

## 🎯 About the Project
The main goal of this project is to development and to understand robust Object-Oriented Programming (OOP) principles with Java. It tests the ability to translate UML class diagrams into functional code, handle file parsing, manage custom exceptions, and apply core design patterns.

#### Key Features:
- **Aircraft Management**: Simulates multiple aircraft types (e.g., Helicopters, Jets, Ballons) with unique IDs and coordinates.

- **Weather Simulation**: Integrates a WeatherTower and a WeatherProvider that dynamically alter conditions (SUN, RAIN, FOG, SNOW), affecting each aircraft differently.

- **Observer Pattern**: Implements clean event-driven communication between the weather tower and registered aircraft.

- **File Parsing & Error Handling**: Reads an initial scenario text file and validates inputs thoroughly, throwing custom exceptions for malformed data, duplicate IDs, or invalid coordinates.

- **Detailed Logging**: Outputs a comprehensive simulation log recording movements, weather shifts, registrations, and landings.

- **Landing & Removal**: When an aircraft's height reaches 0, it automatically lands, unregisters from the weather tower, and outputs a landing log.

## 🛠️ Technologies Used
- **Language**: Java

- **Concepts**: Object-Oriented Programming (OOP), Design Patterns (Observer), File I/O, Exception Handling.

## 🚀 Getting Started
### Prerequisites
- Java Development Kit (JDK 8 or higher recommended)

- Make (optional, if you use a Makefile)

### Compilation & Execution
1. Clone the repository:
  ```java
  git clone [https://github.com/VeraGD/Avaj_Launcher](https://github.com/VeraGD/Avaj_Launcher)
  cd avaj_launcher
  ```

2. Compile the project (or use your preferred build method):

  ```java
  find . -name "*.java" > sources.txt
  javac @sources.txt
  ```

3. Run the simulation using a scenario file:
  ```java
   java Simulation path/to/scenario.txt
  ````

## 📂 Scenario File Format
The simulation takes a text file as input structured as follows:

- **Line 1**: Number of simulation iterations (positive integer).

- **Following lines**: Type of aircraft, name of it, coordinates (longitude + latitude + height). 

Example:

```java
3
Helicopter H1 10 20 30
Jet J1 15 25 40
```

## 🌦️ Weather Generation Algorithm

To determine changing weather conditions dynamically across simulations without relying on standard random libraries, the project uses a deterministic algorithmic approach based on the aircraft's current coordinates.

The weather state is calculated using the sum of an aircraft's coordinates (`longitude + latitude + height`). The resulting sum is divided by 4, and the remainder dictates the current weather condition:

* **Remainder `0`:** ❄️ **SNOW** (Snowing)
* **Remainder `1`:** ☀️ **SUN** (Sunny)
* **Remainder `2`:** 🌧️ **RAIN** (Rainy)
* **Remainder `3`:** 🌫️ **FOG** (Foggy)

```java
int weatherIndex = (longitude + latitude + height) % 4;
