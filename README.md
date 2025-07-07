# Snake and Ladders Game 
 
This is a Java-based **console application** of the classic board game **Snake and Ladders**, built using **Maven**. The project follows a modular and testable architecture with game logic and unit tests included.
 
---
 
## 🛠 Tech Stack
 
- Java 8+
- Maven
- JUnit (for testing)
- Object-Oriented Design
 
---
 
## 📦 Project Structure
 
```
snake-ladders-games/
├── src/
│   ├── main/
│   │   └── java/com/snakeladders/
│ │ ├── GameEngine.java              # Game controller logic
│ │ ├── GameInterface.java           # Interface for game engine
│ │ ├── GameMoveResult.java          # result holder for each move
│ │ ├── SnakesAndLaddersApplication.java  # Main class to run the game
│ │ └── SnakesAndLaddersBoard.java   # Board class with snake/ladder logic
│   └── test/
│       └── java/
│       └── SnakesAndLaddersBoardTest.java  # Unit tests for board behavior
├── pom.xml            # Maven configuration file
└── .gitignore         # Git ignore file
```
 
---
 
## Game Features

- Snakes push you down, ladders take you up
- Ends when a player reaches 100
- Console-based progress messages
- Clean modular code with test coverage
 
---
 
##  How to Run
 
### Run the Game
 
1. Open the project in your IDE.
2. Navigate to:
   ```
src/main/java/com/snakeladders/SnakesAndLaddersApplication.java
   ```
3. Click the green **Run** (▶️) button to start the game.
 
---
 
### 🧪 Run Tests
 
```bash
mvn test
```
 
Test cases are located in:
`src/test/java/SnakesAndLaddersBoardTest.java`
 
---
 
## 📋 Sample Output
 
```
@tanseer123 ➜ /workspaces/snake-ladders-games (main) $  /usr/bin/env /usr/local/sdkman/candidates/java/17.0.15-ms/bin/java -XX:+ShowCodeDetailsInExceptionMessages -cp /workspaces/snake-ladders-games/target/classes com.snakeladders.SnakesAndLaddersApplication 
=== SNAKES & LADDERS GAME ===
Board size: 100 cells
Starting position: 0

Ladders on the board:
  7 -> 33
  37 -> 85
  51 -> 72
  71 -> 91

Snakes on the board:
  36 -> 19
  65 -> 35
  87 -> 32
  98 -> 12

==================================================
Enter dice rolls (1-6) or 'quit' to exit:
Current position: 0, Enter dice roll: 3
Current position: 0, Dice roll: 3
New position: 3
Message: Moved to position 3.
------------------------------
Current position: 3, Enter dice roll: 6
Current position: 3, Dice roll: 6
New position: 9
Message: Moved to position 9.
------------------------------
Current position: 9, Enter dice roll: 6
Current position: 9, Dice roll: 6
New position: 15
Message: Moved to position 15.
------------------------------
Current position: 15, Enter dice roll: 4
Current position: 15, Dice roll: 4
New position: 19
Message: Moved to position 19.
------------------------------
Current position: 19, Enter dice roll: 3
Current position: 19, Dice roll: 3
New position: 22
Message: Moved to position 22.
------------------------------
Current position: 22, Enter dice roll: 4
Current position: 22, Dice roll: 4
New position: 26
Message: Moved to position 26.
------------------------------
Current position: 26, Enter dice roll: 5
Current position: 26, Dice roll: 5
New position: 31
Message: Moved to position 31.
------------------------------
Current position: 31, Enter dice roll: 5
Current position: 31, Dice roll: 5
New position: 19
Message: Bitten by snake at 36, moved down to 19!
------------------------------
Current position: 19, Enter dice roll: 6
Current position: 19, Dice roll: 6
New position: 25
Message: Moved to position 25.
------------------------------
Current position: 25, Enter dice roll: 6
Current position: 25, Dice roll: 6
New position: 31
Message: Moved to position 31.
------------------------------
Current position: 31, Enter dice roll: 3
Current position: 31, Dice roll: 3
New position: 34
Message: Moved to position 34.
------------------------------
Current position: 34, Enter dice roll: 3
Current position: 34, Dice roll: 3
New position: 85
Message: Climbed ladder from 37 to 85!
------------------------------
Current position: 85, Enter dice roll: 5
Current position: 85, Dice roll: 5
New position: 90
Message: Moved to position 90.
------------------------------
Current position: 90, Enter dice roll: 5
Current position: 90, Dice roll: 5
New position: 95
Message: Moved to position 95.
------------------------------
Current position: 95, Enter dice roll: 7
Error: Invalid dice roll: 7. Must be between 1 and 6.
Current position: 95, Enter dice roll: 6
Current position: 95, Dice roll: 6
New position: 95
Message: Cannot move to 101. Staying at 95.
------------------------------
Current position: 95, Enter dice roll: 4
Current position: 95, Dice roll: 4
New position: 99
Message: Moved to position 99.
------------------------------
Current position: 99, Enter dice roll: 1
Current position: 99, Dice roll: 1
New position: 100
Message: Yay!! You won!!
```
 
---
