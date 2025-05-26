/******************************************************************************
 *  MODULE NAME  : Input Handler
 *  FILE         : InputHandler.java
 *  DESCRIPTION  : Handles directional input for the Snake game, validating
 *                 and storing the current movement direction.
 *  AUTHOR       : Yousef Tantawy
 *  DATE CREATED : May 2025
 ******************************************************************************/

/******************************************************************************
 *  PACKAGE: logic
 ******************************************************************************/
package snake_game.logic;

/******************************************************************************
 *  IMPORTS
 ******************************************************************************/
import java.awt.event.KeyEvent;

/******************************************************************************
 *  CLASS NAME   : InputHandler
 *  DESCRIPTION  : Processes and maintains the latest valid direction input from
 *                 the player, preventing invalid or null movements.
 ******************************************************************************/
public class InputHandler 
{
    private Direction move = Direction.RIGHT;  // Currently stored movement direction

    /*
     *  Description: Sets the movement direction if it's one of the four valid
     *               directions; otherwise resets to NULL.
     *  @param d  The desired new direction input.
     */
    public void setDirection(Direction d)
    {
        switch(d)
        {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                move = d;
                break;
            default:
                break;
        }
    }
    
    /*
     *  Description: Retrieves the current movement direction. Returns NULL if
     *               no valid direction has been set.
     *  @return The current Direction value.
     */
    public Direction getCurrentDirection()
    {
        return move;
    }

    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_W:
                setDirection(Direction.UP);
                break;
            case KeyEvent.VK_S:
                setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_A:
                setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                setDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }

    public void keyTyped(KeyEvent e) 
    {
        // Optional: implement if needed
    }
}  

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/
