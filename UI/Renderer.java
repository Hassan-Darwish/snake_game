package snake_game.UI;

import snake_game.*;
import java.awt.*;
import javax.swing.*;

public class Renderer 
{
    // for testing
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Snake in Half-Steps");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 560);
        frame.add(new MyPanel());
        frame.setVisible(true);
    }
}

class MyPanel extends JPanel 
{
    private static final int CELL_SIZE = 40;
    private static final int COLS = 16;
    private static final int ROWS = 14;

    // Snake "head" position (in pixels, can be in between cells)
    private int snakeHeadX = 7 * CELL_SIZE; // e.g., halfway into 6th cell
    private int snakeHeadY = 7 * CELL_SIZE;
    private int eyeX1 = 7 * (CELL_SIZE) + 20;
    private int eyeY1 = 7 * (CELL_SIZE) + 20;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int x = col * CELL_SIZE;
                int y = row * CELL_SIZE;

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, CELL_SIZE, CELL_SIZE);

                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
            }
        }

        // Draw snake head
        g.setColor(Color.WHITE);
        g.fillOval(snakeHeadX, snakeHeadY, CELL_SIZE, CELL_SIZE);  // Still size of 1 full block
        g.setColor(Color.BLACK);
        g.fillOval(eyeX1, eyeY1, CELL_SIZE/5, CELL_SIZE/5);  // Still size of 1 full block  
    }
}
