package snake_game.game;

import snake_game.logic.*;
import snake_game.model.*;
import snake_game.UI.*;


public class Game 
{
    private GameBoard board;
    private Snake snake;
    private Food food;

    private InputHandler input;
    private ScoreManager score;
    private CollisionDetector detector;

    private Renderer renderer;

    public boolean isGamePaused = false;
    public boolean isGameStopped = false;

    public Game(Renderer renderer)
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
        score = new ScoreManager();
        detector = new CollisionDetector();

        this.renderer = renderer;

    }

    public void start()
    {
        for(;;)
        {
            if(isGameStopped)
            {
                break;
            }
            while(!isGamePaused)
            {
                // wait until game is resumed
            }

            snake.move(input.getCurrentDirection());

            if(detector.checkFoodCollision(snake, food))
            {
                snake.grow();
                score.incrementScore();
                
                do
                {
                    food.generateNewFood();
                }
                while((board.isOccupied(food.getPosition(), snake)));
                
                renderer.foodCreation();
            }
            if(detector.checkWallCollision(snake, board))
            {
                gameOver();
            }
            if(detector.checkCollisionWithItself(snake))
            {
                gameOver();
            }
        }
    }
    public void resume()
    {
        isGamePaused = false;
    }
    public void pause()
    {
        isGamePaused = true;
    }
    public void stop()
    {
        isGameStopped = true;
    }
    private void render() 
    {
        renderer.render(snake, food, board, score.getScore());
    }
    private void gameOver() 
    {
        isGameStopped = true;
        renderer.showGameOverScreen(score.getScore());
    }
}
