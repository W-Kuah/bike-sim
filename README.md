# Bike Grid Simulation (Assignment)
A Java application that simulates a bike moving on a 7x7 grid, preventing exits beyond grid boundaries while responding to movement and directional commands.

## Features
- **Grid Environment**: 7x7 grid where (0,0) is the southwest corner
- **Command Handling**: Processes PLACE, FORWARD, TURN_LEFT, TURN_RIGHT, and GPS_REPORT commands
- **Safety Checks**: Prevents the bike from moving outside the grid boundaries
- **Robust Input Handling**: Ignores invalid commands and requires an initial valid PLACE

## Commands
| Command                 | Description                                  | Example                   |
|-------------------------|----------------------------------------------|---------------------------|
| `PLACE X,Y,F`           | Positions bike at (X,Y) facing F direction   | `PLACE 2,3,EAST`          |
| `FORWARD`               | Moves bike forward 1 unit                   |                           |
| `TURN_LEFT`             | Rotates bike 90° counterclockwise           |                           |
| `TURN_RIGHT`            | Rotates bike 90° clockwise                  |                           |
| `GPS_REPORT`            | Outputs current position and direction      | `(2,3), EAST`             |

**Valid Directions**: NORTH, SOUTH, EAST, WEST  
**Grid Boundaries**: X and Y coordinates must be between 0-6 inclusive

## How to Run For Non-Developers.
Note that I do not usually upload artifacts, as it is not good practice. 
However, I felt this would provide a smoother experience for non-developers to run the app.

1. Navigate to this https://github.com/W-Kuah/bike-sim/
2. Click on the 'Code' green button and download zip.
3. Unzip the file and copy the name of the unzipped folder to your clipboard.
e.g.
```plaintext
/Users/your-name/Downloads/bike-sim-main/
```
- On Mac OSX you can do this by right-clicking on the folder and holding down the option button and "Copy <foldername> as Pathname".
- On Windows, follow the instructions on this link: https://www.wikihow.com/Find-a-File's-Path-on-Windows
4. Open your terminal app (Mac) or PowerShell (PC).

5. Type 'cd ' in the command line and copy and paste your path, and enter
e.g. cd /Users/your-name/Downloads/bike-sim-main/

6. Run bash.sh
   ```bash
   java -cp target/bikeSim-1.0-SNAPSHOT.jar org.bikesim.BikeSimApp
   ```
- If on Mac OSX, you can choose to run the following instead:
   ```bash
   bash install.sh
   ```
   
7. If you want to test a text file, try:
   ```bash
   java -cp target/bikeSim-1.0-SNAPSHOT.jar org.bikesim.BikeSimApp input-tests/example1.txt
   ```
- If on Mac OSX, you can choose to run the following instead:
   ```bash
   bash install.sh input-tests/example1.txt
   ```
## How to Run For Developers
0. Ensure you have Maven installed (https://maven.apache.org/install.html)
1. **Clone the repository**  
   ```bash
   git clone https://github.com/W-Kuah/bike-sim/
   cd bike-sim
   ```

3. **Compile from the project root**
   ```bash
   bash install.sh
   ```
   OR
   ```bash
   mvn clean install
   dependency:copy-dependencies
   mvn package
   ```
   
4. **Run with input file**
   ```bash
   bash run.sh input-tests/example1.txt
   ```
   OR
   ```bash
   java -cp target/bikeSim-1.0-SNAPSHOT.jar org.bikesim.BikeSimApp input-tests/example1.txt
   ```
   
   **...OR Read from STDIN**  
   ```bash
   bash run.sh
   ```
   OR
   ```bash
   java -cp target/bikeSim-1.0-SNAPSHOT.jar org.bikesim.BikeSimApp
   ```
   (Type commands manually, press `Ctrl+D` to end input)
   
## Input Examples
```plaintext
PLACE 0,5,NORTH
FORWARD
GPS_REPORT
Output: (0,6), NORTH

```

```plaintext
PLACE 0,0,NORTH
TURN_LEFT
GPS_REPORT
Output: (0,0), WEST

```

```plaintext
PLACE 1,2,EAST
FORWARD
FORWARD
TURN_LEFT
FORWARD
GPS_REPORT
Output: (3,3), NORTH
```

## Design Notes
- Validation: All commands before the first valid PLACE are ignored
- Safety: Movements that would exit the grid are silently skipped
- Re-PLACE: Multiple PLACE commands allowed after initial placement
- Case Sensitivity: Commands and directions are case-insensitive
- Error Handling: Malformed inputs are printed without crashing

File Structure
```
bike-simulation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── bikesim/
│   │   │           ├── enum/
│   │   │           │   └── Direction.java
│   │   │           ├── entities/
│   │   │           │   ├── Bike.java
│   │   │           │   ├── Grid.java
│   │   │           ├── command/
│   │   │           │   ├── Command.java
│   │   │           │   ├── ForwardCommand.java
│   │   │           │   ├── PlaceCommand.java
│   │   │           │   ├── ReportCommand.java
│   │   │           │   ├── TurnLeftCommand.java
│   │   │           │   └── TurnRightCommand.java
│   │   │           ├── parser/
│   │   │           │   └── CommandParser.java
│   │   │           ├── simulator/
│   │   │           │   └── Simulator.java
│   │   │           └── BikeSimApp.java
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── org/
│       │       └── bikesim/
│       │           ├── enum/
│       │           │   └── DirectionTest.java
│       │           ├── entities/
│       │           │   ├── BikeTest.java
│       │           │   ├── GridTest.java
│       │           ├── parser/
│       │           │   └── CommandParserTest.java
│       │           ├── simulator/
│       │           │   └── SimulatorTest.java
│       │           └── BikeSimAppTest.java
│       └── resources/
│
├── input-tests/
│   ├── example1.txt
│   ├── example2.txt
│   └── example3.txt
├── pom.xml
└── README.md
```
## Testing
Sample test files are included in the test-inputs/ directory. Run with:
   ```bash
   bash run.sh input-tests/example1.txt
   ```
   ```bash
   bash run.sh input-tests/example2.txt
   ```
   ```bash
   bash run.sh input-tests/example3.txt
   ```
Alternatively, you may add your file to the input-tests.
   ```bash
   bash run.sh input-tests/your-file.txt
   ```
