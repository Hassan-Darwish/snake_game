/******************************************************************************
 *  MODULE NAME  : Game Board
 *  FILE         : GameBoard.java
 *  DESCRIPTION  : Defines the game board for the Snake game, including board
 *                 boundaries, occupancy checks, and default dimensions.
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
import java.util.LinkedList;
import snake_game.logic.Coordinates;

/******************************************************************************
 *  CLASS NAME   : GameBoard
 *  DESCRIPTION  : Manages the board layout, snake initialization, and checks
 *                 for boundaries and occupied cells.
 ******************************************************************************/
public class GameBoard {
    public static final int DEFAULT_ROW_SIZE = 40;  // Number of rows on the board
    public static final int DEFAULT_COL_SIZE = 30;  // Number of columns on the board

    private Snake snake;  // The snake instance moving on this board

    /*
     *  Constructor: Initializes the game board with a new snake at the center.
     */
    public GameBoard()
    {
        Coordinates snakeStartingPosition = new Coordinates(
            DEFAULT_ROW_SIZE / 2,
            DEFAULT_COL_SIZE / 2
        );
        snake = new Snake(snakeStartingPosition);

        Coordinates appleStartingPosition = new Coordinates(
            DEFAULT_ROW_SIZE / 2 + 10,
            DEFAULT_COL_SIZE / 2
        );
        // Food food = new Food(appleStartingPosition);
    }

    /*
     *  Description: Checks if the given coordinates are within board boundaries.
     *  Returns true if inside bounds, false otherwise.
     */
    public boolean isOutOfBounds(Coordinates boardBoundaries)
    {
        if (boardBoundaries.getX() < 0 ||
            boardBoundaries.getX() >= DEFAULT_ROW_SIZE ||
            boardBoundaries.getY() < 0 ||
            boardBoundaries.getY() >= DEFAULT_COL_SIZE)
        {
            return false;
        }
        return true;
    }

    /*
     *  Description: Determines if a given coordinate is occupied by the snake or
     *               is out of bounds.
     *  Returns true if occupied or out of bounds, false otherwise.
     */
    public boolean isOccupied(Coordinates coordinates)
    {
        if (!isOutOfBounds(coordinates))
        {
            return true;
        }

        LinkedList<Coordinates> snakeBody = snake.getBody();
        for (Coordinates segment : snakeBody)
        {
            if (coordinates.equals(segment))
            {
                return true;
            }
        }
        return false;
    }

    /*
     *  Description: Returns the board width (number of rows).
     */
    public int getWidth()
    {
        return DEFAULT_ROW_SIZE;
    }

    /*
     *  Description: Returns the board height (number of columns).
     */
    public int getHeight()
    {
        return DEFAULT_COL_SIZE;
    }
}

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/
