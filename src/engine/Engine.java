package engine;

import model.Player;
import model.Symbol;

public class Engine {
    private Symbol[][] gameBoard;
    private static final int GAME_BOARD_SIZE = 3;

    public Engine() {
        gameBoard = new Symbol[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
    }

    public void move(Player player, Position position) throws InvalidMoveException {
        if (!isValidMove(position)) {
            throw new InvalidMoveException("The move to column: " + position.getColumn() + " row: " + position.getRow() + " is invalid");
        }
        gameBoard[position.getColumn()][position.getRow()] = player.getSymbol();

    }

    private boolean isValidMove(Position position) {
        if (position.getRow() < 0 || position.getColumn() < 0
                || position.getRow() >= GAME_BOARD_SIZE
                || position.getColumn() >= GAME_BOARD_SIZE) return false;
        Symbol symbol = gameBoard[position.getColumn()][position.getRow()];
        return symbol == null;
    }

    public Symbol getWinner() {
        try {
            if (gameBoard[0][0].equals(gameBoard[0][1]) && gameBoard[0][1].equals(gameBoard[0][2]))
                return gameBoard[0][0];
            if (gameBoard[0][0].equals(gameBoard[1][0]) && gameBoard[1][0].equals(gameBoard[2][0]))
                return gameBoard[0][0];
            if (gameBoard[0][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][2]))
                return gameBoard[0][0];

            if (gameBoard[0][1].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][1]))
                return gameBoard[0][1];

            if (gameBoard[0][2].equals(gameBoard[1][2]) && gameBoard[1][2].equals(gameBoard[2][2]))
                return gameBoard[0][2];
            if (gameBoard[0][2].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[2][0]))
                return gameBoard[0][2];

            if (gameBoard[1][0].equals(gameBoard[1][1]) && gameBoard[1][1].equals(gameBoard[1][2]))
                return gameBoard[1][0];

            if (gameBoard[2][0].equals(gameBoard[2][1]) && gameBoard[2][1].equals(gameBoard[2][2]))
                return gameBoard[2][0];
        } catch (NullPointerException e) {
            return null;
        }


        return null;
    }

    public boolean isDrawn() {
        for (Symbol[] symbols : gameBoard) {
            for (Symbol symbol : symbols) {
                if (symbol == null) return false;
            }
        }
        return true;
    }

    public String getBoardState() {
        StringBuilder builder = new StringBuilder();
        for (Symbol[] symbols : gameBoard) {
            builder.append("| ");
            for (Symbol symbol : symbols) {
                if (symbol != null) {
                    builder.append(symbol.getSign());
                } else {
                    builder.append(" ");
                }
                builder.append(" | ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }


}
