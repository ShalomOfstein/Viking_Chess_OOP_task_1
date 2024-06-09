# Hnefatafl (Viking Chess) Game

## Overview
This project implements a graphical user interface (GUI) for playing the board game Hnefatafl, also known as Viking Chess. Hnefatafl is a historical strategy board game that originated in medieval Scandinavia and was popular among the Vikings. The game involves two players, where one player controls the defending pieces and the other controls the attacking pieces. The objective of the game varies depending on the side you're playing: defenders aim to escort their king to safety, while attackers seek to capture the opponent's king.

## Project Features
### 1. Moving Pieces
Players can move their pieces according to the rules of Hnefatafl. Each type of piece has specific movement patterns, including orthogonal and diagonal movements. The GUI provides a user-friendly interface for selecting and moving pieces.

### 2. Undo Button
The GUI includes an undo button that allows players to reverse their last move. This feature is helpful for correcting mistakes or trying out different strategies during gameplay.

### 3. Declaring Winner
The game logic automatically detects when one player has won. If the defending player successfully moves their king to one of the four corner squares of the board, they win the game. Alternatively, if the attacking player captures the defender's king, they win the game. The GUI displays a victory message and allows players to start a new game or exit.

### 4. Printing Stats
During gameplay, the game gathers statistics such as the number of wins for each player and the number of pieces captured. These stats provide insights into the performance of each player and can be displayed at the end of each game or saved for future reference.

### 5. Graphical Interface
The GUI provides a visually appealing interface for players to interact with. It includes a grid-based game board, colorful pieces representing different player factions, and intuitive controls for moving pieces and accessing game functions.

## Hnefatafl Rules
Hnefatafl is played on an 11x11 board, with one player controlling the defending pieces (black) and the other controlling the attacking pieces (white). The game follows these basic rules:
- The defending player's objective is to move their king piece to one of the four corner squares of the board (thrones).
- The attacking player's objective is to capture the defending player's king by surrounding it on all four orthogonal sides.
- Pieces can move orthogonally (up, down, left, right) any number of empty spaces, but cannot move diagonally.
- Only the king can occupy the corner squares of the board.
- Additional rules can be found [Here](https://www.mastersofgames.com/rules/hnefatafl-viking-chess-rules.htm)

## How to Use the App
1. **Installation**: Clone the repository to your local machine using Git.
  ```sh
  git clone https://github.com/ShalomOfstein/Viking_Chess_OOP_task_1.git
  ```
2. **Compilation**: Compile all Java files in the repository using a Java compiler.
```sh
javac *.java
  ```
3. **Execution**: Run the main Java file to start the game.
```sh
java Main

  ```
4. **Gameplay**: Follow the on-screen instructions to take turns moving your pieces and attempting to achieve victory.
5. **Undo Move**: If you make a mistake, use the undo button to revert your last move.
6. **Winning**: The game will declare a winner and print out statistics to the terminal, when one player achieves victory according to the rules of Hnefatafl. 

## Additional Notes
- This project follows object-oriented principles to separate concerns and facilitate maintainability. It utilizes classes and interfaces to encapsulate game logic, player behavior, and graphical rendering.
- Feel free to customize the game logic or UI to suit your preferences or requirements. You can modify piece movement rules, implement additional features, or enhance the visual design of the GUI.

Enjoy playing Hnefatafl, and may the best strategist win!
