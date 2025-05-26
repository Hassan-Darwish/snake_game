/******************************************************************************
 *  MODULE NAME  : Score Manager
 *  FILE         : ScoreManager.java
 *  DESCRIPTION  : Manages the player's score in the Snake game, providing
 *                 methods to reset, increment, and retrieve the current score.
 *  AUTHOR       : Yousef Tantawy
 *  DATE CREATED : May 2025
 ******************************************************************************/

/******************************************************************************
 *  PACKAGE: logic
 ******************************************************************************/
package snake_game.logic;

/******************************************************************************
 *  CLASS NAME   : ScoreManager
 *  DESCRIPTION  : Tracks and updates the game score based on player actions.
 ******************************************************************************/
public class ScoreManager 
{
    private int score = 0;  // Current score value

    /*
     *  Description: Resets the score back to zero.
     */
    public void reset()
    {
        score = 0;
    }

    /*
     *  Description: Increments the score by one point.
     */
    public void incrementScore()
    {
        score++;
    }

    /*
     *  Description: Retrieves the current score value.
     *  @return The player's current score.
     */
    public int getScore() 
    {
        return score;
    }
}

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/