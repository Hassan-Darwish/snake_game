package snake_game.logic;

public class InputHandler 
{
    private Direction move = Direction.NULL;
    public void setDirection(Direction d)
    {
        switch(d)
        {
            case UP:
            case DOWN:
            case LEFT:
            case RIGHT:
                move = d;
                break;
            default:
                move = Direction.NULL;
                break;
        }
    }
    
    public Direction getCurrentDirection()
    {
        if(move != Direction.NULL)
           return move; 
        return Direction.NULL;
    }
}
