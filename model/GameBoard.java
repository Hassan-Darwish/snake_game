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
    public static final int DEFAULT_ROW_SIZE = 16;  // Number of rows on the board
    public static final int DEFAULT_COL_SIZE = 14;  // Number of columns on the board

    private int[][] board; // the game board itself 

    /*
     *  Constructor: Initializes the game board with a new snake at the center.
     */
    public GameBoard()
    {
        this.board = new int[DEFAULT_COL_SIZE][DEFAULT_ROW_SIZE];
    }

    /*
     *  Description: Checks if the given coordinates are within board boundaries.
     *  Returns false if inside bounds, true otherwise.
     */
    public boolean isOutOfBounds(Coordinates boardBoundaries)
    {
        if (boardBoundaries.getX() < 0 ||
            boardBoundaries.getX() >= DEFAULT_ROW_SIZE ||
            boardBoundaries.getY() < 0 ||
            boardBoundaries.getY() >= DEFAULT_COL_SIZE)
        {
            return true;
        }
        return false;
    }

    /*
     *  Description: Determines if a given coordinate is occupied by the snake or
     *               is out of bounds.
     *  Returns true if occupied or out of bounds, false otherwise.
     */
    public boolean isOccupied(Coordinates coordinates, Snake snake)
    {
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
    public static int getWidth()
    {
        return DEFAULT_ROW_SIZE;
    }

    /*
     *  Description: Returns the board height (number of columns).
     */
    public static int getHeight()
    {
        return DEFAULT_COL_SIZE;
    }
    /*
     * Description: Return the board itself
     */
    public int[][] getBoard()
    {
        return board;
    }
}

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/
