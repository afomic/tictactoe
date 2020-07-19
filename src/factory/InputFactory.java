package factory;

import engine.Input;
import engine.TerminalInput;

public class InputFactory {
    public static Input getInput() {
        return new TerminalInput();
    }
}
