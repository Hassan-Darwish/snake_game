# Java Snake Game

A fully-functional, object-oriented Snake Game developed in Java using **Swing** for the GUI. Designed with clean architecture and modular components to emphasize maintainability, readability, and real-time responsiveness.

## Gameplay Preview

Classic snake mechanics:
- Grow when eating food  
- Avoid walls and yourself 
- Win at a specific score! 

## Project Structure

```plaintext
snake_game/
├── UI/
│   ├── Buttons.java       # Pause, Resume, Stop controls
│   └── Renderer.java      # Responsible for all drawing
├── logic/
│   ├── CollisionDetector.java
│   └── InputHandler.java
├── model/
│   ├── Coordinates.java
│   ├── Food.java
│   ├── Snake.java
│   └── ScoreManager.java
├── game/
│   ├── GameBoard.java
│   └── Game.java          # Main game loop controller
└── Main.java          # Entry point to start the game
```
## :tools: Features
- Grid-based logic for snake and food positioning.
- Modular design: Renderer, Logic, Model separated.
- Keyboard input (WASD) with smooth movement.
- Collision detection with food, walls, and itself.
- Win condition based on score.
  
## How to Run

# Requirements
Java JDK 11+

# Script
```bash
# Compile the project
javac -d out -cp . Main.java game/Game.java logic/*.java model/*.java UI/*.java

# -d out: creates the output directory
# -cp . : sets the classpath so Java can access all imported classes

# Run the game
java -cp out snake_game.Main

```

## Design Highlights
- Designed with SOLID principles for extensibility.
- Real-time game loop with controlled Thread.sleep() delay.
- Intuitive keyboard controls and responsive UI.

## Author
- Hassan Darwish
- Yousef Tantawy
- Ahmed Alaa
- Omar Ashraf
- Amr Tarek


