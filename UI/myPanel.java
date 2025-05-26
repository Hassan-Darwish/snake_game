package snake_game.UI;
import java.awt.*;
import javax.swing.*;

import snake_game.model.GameBoard;

public class myPanel extends JPanel
{
    // Snake "head" position (in pixels, can be in between cells)
    private int snakeHeadX = 7 * Renderer.blockSize;
    private int snakeHeadY = 7 * Renderer.blockSize;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid
        for (int row = 0; row < GameBoard.getWidth(); row++) {
            for (int col = 0; col < GameBoard.getHeight(); col++) {
                int x = col * Renderer.blockSize;
                int y = row * Renderer.blockSize;

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, Renderer.blockSize, Renderer.blockSize);

                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, Renderer.blockSize, Renderer.blockSize);
            }
        }

        // Draw snake head
        g.setColor(Color.WHITE);
        g.fillOval(snakeHeadX, snakeHeadY, Renderer.blockSize, Renderer.blockSize);  // Still size of 1 full block 
    }    
}
