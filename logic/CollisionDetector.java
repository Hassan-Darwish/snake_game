/******************************************************************************
 *  MODULE NAME  : Collision Detector
 *  FILE         : CollisionDetector.java
 *  DESCRIPTION  : Handles all collision logic for the Snake game including
 *                 collisions with food, walls, and the snake itself.
 *  AUTHOR       : Hassan Darwish
 *  DATE CREATED : May 2025
 ******************************************************************************/

/******************************************************************************
 *  PACKAGE: logic
 ******************************************************************************/
package snake_game.logic;

/******************************************************************************
 *  IMPORTS
 ******************************************************************************/
import snake_game.model.GameBoard;
import snake_game.model.Snake;
import snake_game.model.Food;
import java.util.LinkedList;

/******************************************************************************
 *  CLASS NAME   : CollisionDetector
 *  DESCRIPTION  : Provides methods to detect collisions between the snake
 *                 and other objects in the game.
 ******************************************************************************/
public class CollisionDetector 
{
    /*
     *  Description: Checks if the snake's head has collided with the food.
     *  Returns true if the positions match, false otherwise.
     */
    public boolean checkFoodCollision(Snake snake, Food food)
    {
        return snake.getHead().equals(food.getPosition());
    }    

    /*
     *  Description: Checks if the snake's head is outside the board boundaries.
     *  Returns true if out of bounds, false otherwise.
     */
    public boolean checkWallCollision(Snake snake, GameBoard board)
    {
        return board.isOutOfBounds(snake.getHead());
    }

    /*
     *  Description: Checks if the snake has collided with itself.
     *  Returns true if the head overlaps any part of the body (excluding the head),
     *  false otherwise.
     */
    public boolean checkCollisionWithItself(Snake snake)
    {
        Coordinates snakeHead = snake.getHead();
        LinkedList<Coordinates> snakeBody = snake.getBody();

        for (int bodyIndex = 1; bodyIndex < snakeBody.size(); bodyIndex++) 
        {
            if (snakeHead.equals(snakeBody.get(bodyIndex))) 
            {
                return true; 
            }
        }
        return false;
    }
}

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/