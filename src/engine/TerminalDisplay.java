package engine;

public class TerminalDisplay implements Display {

    public TerminalDisplay() {
    }

    @Override
    public void print(String output) {
        System.out.println("______________________________________________________________________________________");
        System.out.println();
        System.out.println(output);
        System.out.println("______________________________________________________________________________________");
    }


}
