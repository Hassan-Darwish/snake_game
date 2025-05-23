/******************************************************************************
 *  MODULE NAME  : Food Entity
 *  FILE         : Food.java
 *  DESCRIPTION  : Represents food items on the Snake game board. Handles
 *                 initialization and random repositioning of the food.
 *  AUTHOR       : Yousef Tantawy
 *  DATE CREATED : May 2025
 ******************************************************************************/

/******************************************************************************
 *  PACKAGE: model
 ******************************************************************************/
package snake_game.model;

/******************************************************************************
 *  IMPORTS
 ******************************************************************************/
import java.util.Random;
import snake_game.logic.Coordinates;

/******************************************************************************
 *  CLASS NAME   : Food
 *  DESCRIPTION  : Manages the food’s coordinates and provides a method to
 *                 randomly generate a new food position within the game board.
 ******************************************************************************/
public class Food
{
    private Coordinates foodCoordinates;  // Current position of the food
    private Random random = new Random(); // Random generator for repositioning

    /*
     *  Constructor: Initializes the food at the specified starting coordinates.
     *  @param initialCoordinates  The starting position of the food.
     */
    public Food(Coordinates initialCoordinates)
    {
        this.foodCoordinates = initialCoordinates;
    }

    /*
     *  Description: Generates a new random position for the food within the
     *               boundaries of the game board.
     */
    public void generateNewFood()
    {
        foodCoordinates.setX(random.nextInt(GameBoard.getWidth()));   
        foodCoordinates.setY(random.nextInt(GameBoard.getHeight()));   
    }

    /*
     *  Description: Retrieves the current position of the food.
     *  @return The Coordinates object representing the food’s location.
     */
    public Coordinates getPosition()
    {
        return foodCoordinates;
    }
}

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/
