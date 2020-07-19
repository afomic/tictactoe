package factory;

import engine.Display;
import engine.TerminalDisplay;

public class DisplayFactory {
    public static Display getDisplay() {
        return new TerminalDisplay();
    }
}
