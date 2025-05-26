package snake_game.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import snake_game.model.GameBoard;

public class myPanel extends JPanel implements KeyListener {

    private int snakeHeadX = 3 * Renderer.blockSize;
    private int snakeHeadY = 7 * Renderer.blockSize;
    private int foodX = 12 * Renderer.blockSize;
    private int foodY = 7 * Renderer.blockSize;

    // Movement direction variables: (0,0) means no movement
    private int dx = 0;
    private int dy = 0;

    private Timer timer;

    public myPanel()
    {
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);

        // Timer triggers every 300 ms, moves snake and repaints
        timer = new Timer(300, e -> {
            moveSnake();
            repaint();
        });
        timer.start();
    }

    private void moveSnake() 
    {
        snakeHeadX += dx * Renderer.blockSize;
        snakeHeadY += dy * Renderer.blockSize;
        
        // Prevent out-of-bounds movement
        snakeHeadX = Math.max(0, Math.min(snakeHeadX, getWidth() - Renderer.blockSize));
        snakeHeadY = Math.max(0, Math.min(snakeHeadY, getHeight() - Renderer.blockSize));
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        for (int row = 0; row < GameBoard.getWidth(); row++) {
            for (int col = 0; col < GameBoard.getHeight(); col++) {
                int x = row * Renderer.blockSize;
                int y = col * Renderer.blockSize;

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, Renderer.blockSize, Renderer.blockSize);

                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, Renderer.blockSize, Renderer.blockSize);
            }
        }

        g.setColor(Color.RED);
        g.fillRect(foodX, foodY, Renderer.blockSize, Renderer.blockSize);

        g.setColor(Color.WHITE);
        g.fillOval(snakeHeadX, snakeHeadY, Renderer.blockSize, Renderer.blockSize);
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        // Update direction
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> { dx = 0; dy = -1; }
            case KeyEvent.VK_S -> { dx = 0; dy = 1; }
            case KeyEvent.VK_A -> { dx = -1; dy = 0; }
            case KeyEvent.VK_D -> { dx = 1; dy = 0; }
        }
    }

    //must override abstract methods keyReleased and keyTyped
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
