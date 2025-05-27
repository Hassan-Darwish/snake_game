package snake_game.UI;

import javax.swing.*;
import snake_game.model.Snake;
import snake_game.model.Food;

public class Renderer 
{
    public static int blockSize = 40;

    private JFrame frame;
    private myPanel panel;

    public Renderer(Snake snake, Food food, InputHandler input) {
        panel = new myPanel(input);
        panel.setSnake(snake);
        panel.setFood(food);

        frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel); // <== this adds your drawing panel to the window
        frame.pack(); // Sizes frame to fit the preferred size of the panel
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Centers the window on screen
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

    public void showGameOverScreen(int score) {
        JOptionPane.showMessageDialog(null,
        "Game Over!\nYour Score: " + score,
        "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean pauseButton() {
        return false;
    }

    public boolean stopButton() {
        return false;
    }

    public void showWin() {
    JOptionPane.showMessageDialog(null,
        "You Won!",
        "Victory", JOptionPane.INFORMATION_MESSAGE);
    }
}
