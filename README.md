# Snake Game

The Snake game in Java is a classic arcade-style game where the player controls a growing snake to eat food while avoiding walls and its own tail. It's built using object-oriented principles and uses Java Swing for the graphical interface.

## Built With

- Java (OOP)
- `javax.swing.*` for GUI components
- `java.awt.event.KeyListener` & `KeyEvent` for controls
- `java.util.List`, `LinkedList`, and `Random` for game logic

## Controls 

- `W` – Move Up  
- `S` – Move Down  
- `A` – Move Left  
- `D` – Move Right  

## How to Run

```bash
# Compile the project
javac -d out -cp . Main.java game/Game.java logic/*.java model/*.java UI/*.java

# -d out: creates the output directory
# -cp . : sets the classpath so Java can access all imported classes

# Run the game
java -cp out snake_game.Main

# No external libraries or installations are required — everything runs with standard Java.
