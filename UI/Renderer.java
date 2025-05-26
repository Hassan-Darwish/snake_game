/*
 * Renderer.java
 * Bridges Game logic to Swing UI with myPanel
 */
package snake_game.UI;

import javax.swing.*;
import snake_game.model.Snake;
import snake_game.model.Food;
import snake_game.model.GameBoard;

public class Renderer {
    public static int blockSize = 40;

    private JFrame frame;
    private myPanel panel;

    public Renderer(Snake snake, Food food) {
        panel = new myPanel();
        panel.setSnake(snake);
        panel.setFood(food);

        frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void snakeDrawing(Snake snake) {
        panel.setSnake(snake);
        panel.repaint();
    }

    public void foodCreation(Food food) {
        panel.setFood(food);
        panel.repaint();
    }

    public void render(Snake snake, Food food, GameBoard board, int score) {
        panel.setSnake(snake);
        panel.setFood(food);
        panel.repaint();
    }

    public void showGameOverScreen(int score) {
        JOptionPane.showMessageDialog(
            frame,
            "Game Over!\nYour score: " + score,
            "Game Over",
            JOptionPane.INFORMATION_MESSAGE
        );
        frame.dispose();
    }

    public boolean pauseButton() {
        // Hook pause controls here if desired
        return false;
    }

    public boolean stopButton() {
        // Hook stop controls here if desired
        return false;
    }
}