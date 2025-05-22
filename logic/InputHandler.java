package snake_game.logic;

public class InputHandler 
{
    private Direction move = Direction.NULL;
    public void setDirection(Direction d)
    {
        switch(d)
        {
            case W:
            case S:
            case A:
            case D:
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
