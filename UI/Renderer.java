package snake_game.UI;

import snake_game.model.*;
import snake_game.model.GameBoard;
import snake_game.UI.*;

import java.awt.*;
import javax.swing.*;
public class Renderer
{
    protected static int blockSize = 40;
    // Renderer(GameBoard board, Food food, Snake snake)
    // {

    // }
    // void boardCreation(GameBoard board)
    // {

    // }
    // void foodCreation(Food food)
    // {

    // }
    // void snakeDrawing(Snake snake)
    // {
    //     for(int i = 0; i < snake.getBody().size();i++)
    //     {

    //     }
    // }


    // for testing
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GameBoard.getWidth()*blockSize, GameBoard.getHeight()*blockSize);
        frame.add(new myPanel.myPanel());
        frame.setVisible(true);
    }
}

// class MyPanel extends JPanel
// {

//     // Snake "head" position (in pixels, can be in between cells)
//     private int snakeHeadX = 7 * blockSize;
//     private int snakeHeadY = 7 * blockSize;
//     private int eyeX1 = 7 * (blockSize) + 20;
//     private int eyeY1 = 7 * (blockSize) + 20;

//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);

//         // Draw grid
//         for (int row = 0; row < ROWS; row++) {
//             for (int col = 0; col < COLS; col++) {
//                 int x = col * CELL_SIZE;
//                 int y = row * CELL_SIZE;

//                 g.setColor(Color.LIGHT_GRAY);
//                 g.fillRect(x, y, CELL_SIZE, CELL_SIZE);

//                 g.setColor(Color.DARK_GRAY);
//                 g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
//             }
//         }

//         // Draw snake head
//         g.setColor(Color.WHITE);
//         g.fillOval(snakeHeadX, snakeHeadY, CELL_SIZE, CELL_SIZE);  // Still size of 1 full block
//         g.setColor(Color.BLACK);
//         g.fillOval(eyeX1, eyeY1, CELL_SIZE/5, CELL_SIZE/5);  // Still size of 1 full block  
//     }
// }
