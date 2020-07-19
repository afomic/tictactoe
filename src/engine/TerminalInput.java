package engine;

import java.util.Scanner;

public class TerminalInput implements Input{

    @Override
    public int getIntegerInput(String prompt){
        Scanner scanner=new Scanner(System.in);
        System.out.print(prompt+": ");
        int number;
        try{
            number = scanner.nextInt();
        }catch (Exception e){
            System.out.println("An integer is required try again!");
            return getIntegerInput(prompt);
        }
        return number;
    }

    @Override
    public String getStringInput(String prompt){
        Scanner scanner=new Scanner(System.in);
        System.out.print(prompt+": ");
        return scanner.nextLine();
    }
}
