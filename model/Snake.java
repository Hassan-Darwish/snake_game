package snake_game.model;
import snake_game.logic.Coordinates;
import snake_game.logic.Direction;
import java.util.LinkedList;

public class Snake 
{
    private LinkedList<Coordinates> snakeBody;
    private Direction currentDirection;

    public Snake(Coordinates initialPosition)
    {
        snakeBody = new LinkedList<>();
        snakeBody.add(initialPosition); 
        currentDirection = Direction.LEFT;
    }
    public void move(Direction direction)
    {
        if(!(isLegalDirection(direction)))
        {
            return;
        }
        Coordinates snakeHead = changeOfPoisition(direction);
        snakeBody.addFirst(snakeHead);
        snakeBody.removeLast();
    }
    private boolean isLegalDirection(Direction newDir) {
    if ((currentDirection == Direction.UP && newDir == Direction.DOWN) ||
        (currentDirection == Direction.DOWN && newDir == Direction.UP) ||
        (currentDirection == Direction.LEFT && newDir == Direction.RIGHT) ||
        (currentDirection == Direction.RIGHT && newDir == Direction.LEFT)) {
        return false; 
    }
    currentDirection = newDir;
    return true;
    }
    public void grow()
    {
        Coordinates snakeHead = changeOfPoisition(currentDirection);
        snakeBody.addFirst(snakeHead);
    }
    public boolean checkCollisionWithItself()
    {
        Coordinates snakeHead = snakeBody.getFirst();

        for (int bodyIndex = 1; bodyIndex < snakeBody.size(); bodyIndex++) 
        {
            if (snakeHead.equals(snakeBody.get(bodyIndex))) 
            {
                return true; 
            }
        }
        return false;
    }
    public Coordinates getHead()
    {
        return snakeBody.getFirst();
    } 
    public LinkedList<Coordinates> getbody()
    {
        return snakeBody;
    }
    private Coordinates changeOfPoisition(Direction direction)
    {
        Coordinates snakeHead = snakeBody.getFirst();

        switch(currentDirection)
        {
            case UP:
            return new Coordinates(snakeHead.x, snakeHead.y+1);
            case DOWN:
            return new Coordinates(snakeHead.x, snakeHead.x-1);
            case LEFT:
            return new Coordinates(snakeHead.x-1, snakeHead.y);
            case RIGHT: 
            return new Coordinates(snakeHead.x+1, snakeHead.y);
            default:
            return snakeHead;
        }
    }
}
