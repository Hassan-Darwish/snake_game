/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;


/**
 *
 * @author Yousef Tantawy
 */
public class InputHandler 
{
    private Direction move = Direction.NULL;
    public void setDirection(Direction d)
    {
        switch(d)
        {
            case Direction.W:
            case Direction.S:
            case Direction.A:
            case Direction.D:
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
