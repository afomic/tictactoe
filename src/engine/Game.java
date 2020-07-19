package engine;

import model.Player;

public interface Game {
    String getName();
    void start();
    void end();
    void move(Position position, Player player) throws InvalidMoveException;
    Player getPlayerOne();
    Player getPlayerTwo();
    boolean isOver();
}
