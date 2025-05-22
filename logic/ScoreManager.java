package snake_game.logic;

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
