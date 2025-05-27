package snake_game.UI;
import java.awt.event.*;

import snake_game.logic.Direction;

public class InputHandler implements KeyListener
{
    private int dx = 1; // default: RIGHT
    private int dy = 0;

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

    public Direction getDirection() 
    {
        if (this.getX() == 1 && this.getY() == 0) return Direction.RIGHT;
        if (this.getX()  == -1 && this.getY() == 0) return Direction.LEFT;
        if (this.getX()  == 0 && this.getY() == 1) return Direction.DOWN;
        if (this.getX()  == 0 && this.getY() == -1) return Direction.UP;
        return Direction.RIGHT;
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public int getX()
    {
        return dx;
    }

    public int getY()
    {
        return dy;
    }
}