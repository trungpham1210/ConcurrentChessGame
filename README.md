---

# Concurrent Chess Match Simulator

## Project Description
A Java-based application that simulates a chess match between two players using multithreading. The application ensures synchronized moves between players, providing a realistic and efficient simulation of a chess game.

## Features
- **Thread Synchronization**: Utilizes `synchronized` blocks and `wait()`/`notify()` methods to coordinate the moves of two players, ensuring that each player waits for the other to make a move before proceeding.
- **Move Verification**: Implements a `MoveRecord` class to track and verify the order of moves, ensuring the integrity of the game.
- **Comprehensive Testing**: Includes a suite of JUnit test cases to validate the functionality of the application under various scenarios, from single moves to complex sequences of moves.
- **Immutability and Thread Safety**: Ensures that the `ChessMove` class is immutable, providing thread-safe operations and preventing unintended modifications.

## Technologies Used
- **Java**
- **Multithreading**
- **Concurrency**
- **JUnit**

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven or Gradle for dependency management

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/trungpham1210/concurrent-Chest-Game.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Concurrent-Chess-Gatch-simulator
   ```
3. Build the project using Maven or Gradle:
   ```sh
   mvn clean install
   ```
   or
   ```sh
   gradle build
   ```

### Running the Tests
To run the JUnit test cases, use the following command:
```sh
mvn test
```
or
```sh
gradle test
```

## Usage
1. Create instances of `ChessMove` for each player's moves.
2. Use the `ChessMatch` class to simulate the match by calling the `playMoves` method with the lists of moves for both players.
3. Verify the move order using the `MoveRecord` class.

## Example
```java
List<ChessMove> playerOneMoves = List.of(new ChessMove("King", 5, 1, 1, 2));
List<ChessMove> playerTwoMoves = List.of(new ChessMove("Pawn", 0, 1, 1, 3));

ChessMatch match = new ChessMatch();
MoveRecord results = match.playMoves(playerOneMoves, playerTwoMoves);

assert(results.verifyMoveOrder(playerOneMoves, playerTwoMoves));
```

## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
