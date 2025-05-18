/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

/**
 *
 * @author Yousef Tantawy
 */
public class ScoreManager 
{
    private int score = 0;
    public void reset()
    {
        score = 0;
    }
    public void incrementScore()
    {
        score++;
    }
    public int getScore() 
    {
        return score;
    }
}
