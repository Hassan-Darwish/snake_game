package snake_game.game;

import snake_game.logic.*;
import snake_game.model.*;
import snake_game.UI.*;


public class Game 
{
    private GameBoard board;
    private Snake snake;
    private Food food;

    //private InputHandler input;
    private ScoreManager score;
    private CollisionDetector detector;

    private Renderer renderer;

    public boolean isGamePaused = false;
    public boolean isGameStopped = false;

    private static final int winningScore = 221;

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

        renderer = new Renderer(snake, food);

        score = new ScoreManager();
        detector = new CollisionDetector();
    }

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

            snake.move(renderer.getDirection());

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
    private void gameOver() 
    {
        renderer.showGameOverScreen(score.getScore());
    }

    private void win()
    {
        renderer.showWin();
    }
}
