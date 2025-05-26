/*
 * myPanel.java
 * Pure rendering panel that uses model classes Snake and Food
 */
package snake_game.UI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import snake_game.model.Snake;
import snake_game.model.Food;
import snake_game.model.GameBoard;
import snake_game.logic.Coordinates;

public class myPanel extends JPanel {
    private Snake snake;
    private Food food;

    public myPanel() {
        setPreferredSize(new Dimension(
            GameBoard.getWidth() * Renderer.blockSize,
            GameBoard.getHeight() * Renderer.blockSize
        ));
    }

    public void setSnake(Snake snake) 
    {
        this.snake = snake;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid
        for (int x = 0; x < GameBoard.getWidth(); x++) {
            for (int y = 0; y < GameBoard.getHeight(); y++) {
                int px = x * Renderer.blockSize;
                int py = y * Renderer.blockSize;
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(px, py, Renderer.blockSize, Renderer.blockSize);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(px, py, Renderer.blockSize, Renderer.blockSize);
            }
        }

        // Draw food
        if (food != null) {
            Coordinates fpos = food.getPosition();
            int fx = fpos.getX() * Renderer.blockSize;
            int fy = fpos.getY() * Renderer.blockSize;
            g.setColor(Color.RED);
            g.fillRect(fx, fy, Renderer.blockSize, Renderer.blockSize);
        }

        // Draw snake
        if (snake != null) {
            List<Coordinates> body = snake.getBody();
            for (int i = 0; i < body.size(); i++) {
                Coordinates segment = body.get(i);
                int sx = segment.getX() * Renderer.blockSize;
                int sy = segment.getY() * Renderer.blockSize;
                if (i == 0) {
                    g.setColor(Color.WHITE); // head
                } else {
                    g.setColor(Color.GREEN); // body
                }
                g.fillOval(sx, sy, Renderer.blockSize, Renderer.blockSize);
            }
        }
    }
}