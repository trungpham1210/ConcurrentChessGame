# 🧠 ChessMatch – Multithreaded Move Coordination

## 📄 Description
This Java program simulates a turn-based chess game between two players using **multithreading and synchronized inter-thread communication**. The `ChessMatch` class contains two `Runnable` inner classes: `Dinh` and `Pham`, representing two chess players taking turns to make moves. Each player's moves are alternately added to a shared `MoveRecord`, ensuring that moves are synchronized properly using `wait()` and `notify()` within a `synchronized` block.

---

## 🚀 Features
- Simulates a concurrent chess match where two players alternate moves
- Uses **synchronized blocks** and **wait/notify** mechanisms for thread-safe communication
- Demonstrates multithreaded coordination and shared resource management
- Includes a timeout mechanism to detect and handle long-running or stuck threads

---

## 🔧 How It Works
- `Dinh` (player one) places a move, notifies `Pham`, and waits for a response.
- `Pham` (player two) waits for a move from `Dinh`, adds it to the move record, then responds with a move of their own.
- The `MoveRecord` is updated with each move, alternating between the players.
- Execution is managed using the Java `Thread` API and synchronized access to the `ChessMatch` object.

---

## 🛠️ Technologies Used
- Java
- Core multithreading (`Thread`, `Runnable`)
- Synchronization primitives (`synchronized`, `wait()`, `notify()`)
- Custom data types: `ChessMove`, `MoveRecord` (provided externally)

---

## 🧪 How to Run
1. Use Java 8 or higher.
2. Ensure that `ChessMove` and `MoveRecord` classes are included in the same package (`edu.utdallas.cs4348`).
3. Call the `playMoves(List<ChessMove>, List<ChessMove>)` method with each player’s moves to simulate the match.
4. The returned `MoveRecord` will contain the full sequence of alternating moves.

---

## 📌 Example Usage
```java
ChessMatch match = new ChessMatch();
List<ChessMove> player1Moves = Arrays.asList(...);
List<ChessMove> player2Moves = Arrays.asList(...);
MoveRecord record = match.playMoves(player1Moves, player2Moves);
