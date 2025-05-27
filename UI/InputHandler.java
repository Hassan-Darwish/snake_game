package snake_game.UI;
import java.awt.event.*;

import snake_game.logic.Direction;

public class InputHandler implements KeyListener
{
    private int dx = 1; // default: RIGHT
    private int dy = 0;

    @Override
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_W:
                dx = 0; dy = 1;
                break;
            case KeyEvent.VK_S:
                dx = 0; dy = -1;
                break;
            case KeyEvent.VK_A:
                dx = -1; dy = 0;
                break;
            case KeyEvent.VK_D:
                dx = 1; dy = 0;
                break;
        }
    }

    public Direction getDirection() 
    {
        if (dx == 1 && dy == 0) return Direction.RIGHT;
        if (dx  == -1 && dy == 0) return Direction.LEFT;
        if (dx  == 0 && dy == -1) return Direction.DOWN;
        if (dx  == 0 && dy == 1) return Direction.UP;
        return Direction.RIGHT;
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}