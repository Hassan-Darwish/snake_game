package snake_game.UI;

import snake_game.model.*;
import snake_game.model.GameBoard;
import snake_game.UI.*;

import java.awt.*;
import javax.swing.*;
public class Renderer
{
    protected static int blockSize = 40;
    Renderer(GameBoard board, Food food, Snake snake)
    {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GameBoard.getWidth()*blockSize, GameBoard.getHeight()*blockSize);
        frame.add(new myPanel());
        frame.setVisible(true);
    }
    void boardCreation(GameBoard board)
    {

    }
    void foodCreation(Food food)
    {

    }
    void snakeDrawing(Snake snake)
    {
        for(int i = 0; i < snake.getBody().size();i++)
        {

        }
    }


    // for testing
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(GameBoard.getWidth()*blockSize+17, GameBoard.getHeight()*blockSize+34);
        frame.add(new myPanel());
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
