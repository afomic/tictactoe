import engine.*;
import model.Player;
import model.Symbol;

public class TicTacToeGame implements Game {
    private Engine gameEngine;
    private Player playerOne;
    private Player playerTwo;
    private Display display;

    @Override
    public String getName() {
        return "TicTacToe";
    }

    @Override
    public void start() {
        if (display == null) {
            throw new UnsupportedOperationException("Display is required to communicate with player");
        }
        if (gameEngine == null) {
            throw new UnsupportedOperationException("Game Engine cannot be null");
        }

        if (playerOne == null || playerTwo == null) {
            display.print("This is a multi player game and require two players");
            return;
        }
        display.print(gameEngine.getBoardState());
    }

    @Override
    public boolean isOver() {
        return gameEngine.isDrawn() || gameEngine.getWinner() != null;
    }

    @Override
    public void move(Position position, Player player) throws InvalidMoveException {
        gameEngine.move(player, position);
        Symbol winner = gameEngine.getWinner();
        if (winner != null) {
            display.print("We have a winner!!! player: " + player.getName() + " won");
        } else if (gameEngine.isDrawn()) {
            display.print("The game has been drawn");
        }
        display.print(gameEngine.getBoardState());
    }

    @Override
    public Player getPlayerOne() {
        return playerOne;
    }

    @Override
    public Player getPlayerTwo() {
        return playerTwo;
    }


    @Override
    public void end() {

    }

    public static class Builder {
        private Player playerOne;
        private Player playerTwo;
        private Display display;

        public Builder() {
        }

        public Builder withPayerOne(Player player) {
            playerOne = player;
            return this;
        }

        public Builder withPayerTwo(Player player) {
            playerTwo = player;
            return this;
        }

        public Builder withDisplay(Display display) {
            this.display = display;
            return this;
        }

        public Game build() {
            TicTacToeGame game = new TicTacToeGame();
            game.gameEngine = new Engine();
            game.display = display;
            game.playerOne = playerOne;
            game.playerTwo = playerTwo;
            return game;
        }


    }
}
