package model;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;
    public ComputerPlayer(String name, Symbol symbol) {
        super(name, symbol);
        random=new Random();
    }
    public int getRow(){
        return random.nextInt(3);
    }
    public int getColumn(){
        return random.nextInt(3);
    }
}
