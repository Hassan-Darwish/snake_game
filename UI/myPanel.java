package snake_game.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import snake_game.model.Snake;
import snake_game.model.Food;
import snake_game.model.GameBoard;
import snake_game.logic.Coordinates;
import snake_game.logic.Direction;

public class myPanel extends JPanel implements KeyListener {
    private Snake snake;
    private Food food;

    private int dx = 1;  // initial direction: RIGHT (1, 0)
    private int dy = 0;

    public myPanel() {
        setPreferredSize(new Dimension(
            GameBoard.getWidth() * Renderer.blockSize,
            GameBoard.getHeight() * Renderer.blockSize
        ));
        setFocusable(true);
        addKeyListener(this);
        requestFocusInWindow();
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Direction getCurrentDirection() {
        if (dx == 1 && dy == 0) return Direction.RIGHT;
        if (dx == -1 && dy == 0) return Direction.LEFT;
        if (dx == 0 && dy == 1) return Direction.DOWN;
        if (dx == 0 && dy == -1) return Direction.UP;
        return Direction.RIGHT; // default fallback
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
            g.fillOval(fx, fy, Renderer.blockSize, Renderer.blockSize);
        }

        // Draw snake
        if (snake != null) {
            List<Coordinates> body = snake.getBody();
            for (int i = 0; i < body.size(); i++) {
                Coordinates segment = body.get(i);
                int sx = segment.getX() * Renderer.blockSize;
                int sy = segment.getY() * Renderer.blockSize;
                g.setColor(i == 0 ? Color.WHITE : Color.GREEN);
                g.fillOval(sx, sy, Renderer.blockSize, Renderer.blockSize);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (dy != 1) { dx = 0; dy = -1; }
                break;
            case KeyEvent.VK_S:
                if (dy != -1) { dx = 0; dy = 1; }
                break;
            case KeyEvent.VK_A:
                if (dx != 1) { dx = -1; dy = 0; }
                break;
            case KeyEvent.VK_D:
                if (dx != -1) { dx = 1; dy = 0; }
                break;
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
