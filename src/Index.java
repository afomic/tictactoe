import engine.*;
import factory.DisplayFactory;
import factory.InputFactory;
import model.*;

public class Index {
    private static boolean isPlayerOneMove = true;
    private static final boolean SINGLE_PLAYER_MODE=true;

    public static void main(String[] args) {
        Display display = DisplayFactory.getDisplay();
        Input input = InputFactory.getInput();
        showIntroduction(display);
        Game game = createNewGame(display, input,SINGLE_PLAYER_MODE);
        game.start();
        while (!game.isOver()) {
            Player player = isPlayerOneMove ? game.getPlayerOne() : game.getPlayerTwo();
            String moveTitle =player.getName()+"'s move";
            display.print(moveTitle);
            Position nextPosition = getMove(player, input);
            try{
                game.move(nextPosition, player);
                isPlayerOneMove = !isPlayerOneMove;
            }catch (InvalidMoveException e){
                if(!SINGLE_PLAYER_MODE||isPlayerOneMove){
                    display.print("Error: " + e.getMessage());
                }

            }

        }


    }

    private static Position getMove(Player player, Input input) {
        if (player instanceof ComputerPlayer) {
            ComputerPlayer computerPlayer = (ComputerPlayer) player;
            return new Position(computerPlayer.getColumn(), computerPlayer.getRow());
        }
        int column = input.getIntegerInput("Enter the your move column");
        int row = input.getIntegerInput("Enter the your move row");
        return new Position(column,row);
    }

    private static Game createNewGame(Display display, Input input,boolean singlePlayer) {
        display.print("lets create new Game");
        String playerOneName = input.getStringInput("Please enter player one name");
        String playerOneSymbol = input.getStringInput("Please enter player one Symbol");
        Player player = new NormalPlayer(playerOneName, new Symbol(playerOneSymbol));
        Player playerTwo=null;
        if(singlePlayer){
            playerTwo = new ComputerPlayer("Computer", new Symbol("X"));
        }else {
            String playerTwoName = input.getStringInput("Please enter player two name");
            String playerTwoSymbol = input.getStringInput("Please enter player two Symbol");
            playerTwo = new PremiumPlayer(playerTwoName, new Symbol(playerTwoSymbol));
        }

        return new TicTacToeGame.Builder().withDisplay(display)
                .withPayerOne(player)
                .withPayerTwo(playerTwo)
                .build();

    }

    private static void showIntroduction(Display display) {
        display.print("Welcome to the awesome tic tac toe. this game will blow your mind...Aswear");
    }


}
