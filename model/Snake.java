/******************************************************************************
 *  MODULE NAME  : Snake Game - Snake Entity
 *  FILE         : Snake.java
 *  DESCRIPTION  : This class represents the Snake in the classic Snake game.
 *                 It handles the snake’s movement, direction logic, growth, 
 *                 and body tracking.
 *  AUTHOR       : Hassan Darwish
 *  DATE CREATED : May 2025
 ******************************************************************************/

/******************************************************************************
 *  PACKAGE: model
 ******************************************************************************/
package snake_game.model;

/******************************************************************************
 *  IMPORTS
 ******************************************************************************/
import snake_game.logic.Coordinates;
import snake_game.logic.Direction;
import java.util.LinkedList;

/******************************************************************************
 *  CLASS NAME   : Snake
 *  DESCRIPTION  : Models the snake's body, movement, and growth mechanics.
 ******************************************************************************/
public class Snake 
{
    private LinkedList<Coordinates> snakeBody;     // Stores all coordinates of the snake segments
    private Direction currentDirection;            // The current direction of movement

    /*
     *  Constructor: Initializes the snake with a given starting position
     *               and sets the default direction to RIGHT.
     */
    public Snake(Coordinates initialPosition)
    {
        snakeBody = new LinkedList<>();
        snakeBody.add(initialPosition); 
        currentDirection = Direction.RIGHT;
        
        snakeBody.add(new Coordinates(initialPosition.getX() - 1, initialPosition.getY()));
        snakeBody.add(new Coordinates(initialPosition.getX() - 2, initialPosition.getY()));
    }

    /*
     *  Description: Moves the snake in the specified direction if it's legal.
     *               Adds a new head position and removes the tail.
     */

    public void move(Direction direction)
    {
        Coordinates snakeHead;
        if (!isLegalDirection(direction))
        {
            snakeHead = changeOfPosition(currentDirection);

        }
        else
        {
            snakeHead = changeOfPosition(direction);
        }
        snakeBody.addFirst(snakeHead);
        snakeBody.removeLast();
    }
    /*
     *  Description: Checks whether the new direction is legal.
     *               Prevents reversing into itself.
     */
    private boolean isLegalDirection(Direction newDir)
    {
        if ((currentDirection == Direction.UP && newDir == Direction.DOWN) ||
            (currentDirection == Direction.DOWN && newDir == Direction.UP) ||
            (currentDirection == Direction.LEFT && newDir == Direction.RIGHT) ||
            (currentDirection == Direction.RIGHT && newDir == Direction.LEFT))
        {
            return false; 
        }
        currentDirection = newDir;
        return true;
    }

    /*
     *  Description: Adds a new head to the snake without removing the tail,
     *               effectively growing the snake.
     */
    public void grow()
    {
        Coordinates snakeHead = changeOfPosition(currentDirection);
        snakeBody.addFirst(snakeHead);
    }

    /*
     *  Description: Returns the coordinates of the snake's head.
     */
    public Coordinates getHead()
    {
        return snakeBody.getFirst();
    } 

    /*
     *  Description: Returns the full body of the snake as a list of coordinates.
     */
    public LinkedList<Coordinates> getBody()
    {
        return snakeBody;
    }

    /*
     *  Description: Computes the next position of the snake head based on direction.
     */
    private Coordinates changeOfPosition(Direction direction)
{
    Coordinates snakeHead = snakeBody.getFirst();

    switch (currentDirection)
    {
        case UP:
            return new Coordinates(snakeHead.getX(), snakeHead.getY() - 1); // Y-- for up
        case DOWN:
            return new Coordinates(snakeHead.getX(), snakeHead.getY() + 1); // Y++ for down
        case LEFT:
            return new Coordinates(snakeHead.getX() - 1, snakeHead.getY());
        case RIGHT:
            return new Coordinates(snakeHead.getX() + 1, snakeHead.getY());
        default:
            return snakeHead;
    }
}

}

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/
