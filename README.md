# Bike Grid Simulation

A Java application that simulates a bike moving on a 7x7 grid, preventing exits beyond grid boundaries while responding to movement and directional commands.

## Features
- **Grid Environment**: 7x7 grid where (0,0) is the southwest corner
- **Command Handling**: Processes PLACE, FORWARD, TURN_LEFT, TURN_RIGHT, and GPS_REPORT commands
- **Safety Checks**: Prevents bike from moving outside the grid boundaries
- **Robust Input Handling**: Ignores invalid commands and requires initial valid PLACE

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

## How to Run
1. **Clone the repository**  
   ```bash
   git clone https://github.com/W-Kuah/bike-sim/edit/main/README.md
   ```

3. **Compile from the project root**
   ```bash
   bash install.sh
   ```
4. **Run with input file**
   ```bash
   bash run.sh example1.txt
   ```   
5. **OR Read from STDIN**  
   ```bash
   bash run.sh
   (Type commands manually, press `Ctrl+D` to end input)
   ```
   
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
- Validation: All commands before first valid PLACE are ignored
- Safety: Movements that would exit the grid are silently skipped
- Re-PLACE: Multiple PLACE commands allowed after initial placement
- Case Sensitivity: Commands and directions are case-insensitive
- Error Handling: Malformed inputs are print without crashing

File Structure
code

Testing
Sample test files are included in test-inputs/ directory. Run with:
