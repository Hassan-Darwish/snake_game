/******************************************************************************
 *  MODULE NAME  : Game Loop Controller
 *  FILE         : Game.java
 *  DESCRIPTION  : Coordinates all Snake game components: board, snake, food,
 *                 rendering, scoring, and collision detection. Manages the
 *                 main game loop, pause/resume, win and game-over states.
 *  AUTHOR       : Hassan Darwish
 *  DATE CREATED : May 2025
 ******************************************************************************/
package snake_game.game;

import snake_game.logic.*;
import snake_game.model.*;
import snake_game.UI.*;


/******************************************************************************
 *  CLASS NAME   : Game
 *  DESCRIPTION  : Implements the main game loop and orchestrates interactions
 *                 between game entities and UI renderer.
 ******************************************************************************/
public class Game 
{
    private GameBoard board;                // Game board grid
    private Snake snake;                    // Snake entity
    private Food food;                      // Food entity

    private ScoreManager score;             // Score tracking
    private CollisionDetector detector;     // Collision logic

    private Renderer renderer;              // UI rendering
    private InputHandler input;

    public boolean isGamePaused = false;    // Pause flag
    public boolean isGameStopped = false;   // Stop flag

    private static final int winningScore = 221; // Score required to win

    /*
     *  Constructor: Initializes game components and their starting positions.
     */
    public Game()
    {
        board = new GameBoard();

        Coordinates snakeStartingPosition = new Coordinates
        (
            GameBoard.getWidth() / 5,
            GameBoard.getHeight() / 7
        );
        snake = new Snake(snakeStartingPosition);

        Coordinates appleStartingPosition = new Coordinates
        (
            GameBoard.getWidth() / 5 + 9,
            GameBoard.getHeight() / 7
        );
        food = new Food(appleStartingPosition);

        input = new InputHandler();
        renderer = new Renderer(snake, food, input);

        score = new ScoreManager();
        detector = new CollisionDetector();
    }

    /*
     *  Description: Starts and runs the main game loop until stop condition.
     */
    public void start()
    {
        while(!isGameStopped)
        {
            isGameStopped = renderer.stopButton();
            isGamePaused = renderer.pauseButton();

            if(isGamePaused)
            {
                while(isGamePaused && !isGameStopped)
                {
                    isGameStopped = renderer.stopButton();
                    isGamePaused = renderer.pauseButton();
                    sleep();  
                }
            }

            snake.move(input.getDirection());

            if(detector.checkFoodCollision(snake, food))
            {
                snake.grow();
                score.incrementScore();
                
                do
                {
                    food.generateNewFood();
                }
                while((board.isOccupied(food.getPosition(), snake)));
                
                renderer.foodCreation(food);
            }
            if(detector.checkWallCollision(snake, board))
            {
                gameOver();
                break;
            }
            if(detector.checkCollisionWithItself(snake))
            {
                gameOver();
                break;
            }
            renderer.snakeDrawing(snake);

            if(score.getScore() == winningScore)
            {
                win();
                break;
            }

            sleep();
        }
    }

    /*
     *  Description: Pauses execution for a fixed interval to control game speed.
     */
    private void sleep() 
    {
        try 
        {
            Thread.sleep(200); // controls game speed
        } catch(InterruptedException e)
        {
            e.printStackTrace();
         }
    }

    /*
     *  Description: Triggers the game over UI and stops the loop.
     */
    private void gameOver() 
    {
        renderer.showGameOverScreen(score.getScore());
    }

    /*
     *  Description: Triggers the win UI when the winning score is reached.
     */
    private void win()
    {
        renderer.showWin();
    }
}

/******************************************************************************
 *  END OF FILE
 ******************************************************************************/