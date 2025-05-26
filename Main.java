package snake_game;

import snake_game.game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();   // instantiate
        game.start();             // kick off the game loop
    }
}
