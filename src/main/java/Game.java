import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TabBehaviour;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    private Terminal terminal = new DefaultTerminalFactory().createTerminal();
    private Screen screen = new TerminalScreen(terminal);

    private int x = 10;
    private int y = 10;

    public Game() throws IOException {

         /*
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        */

        try {
            screen.setCursorPosition(null); // we don't need a cursor
            screen.startScreen(); // screens must be started
            screen.doResizeIfNecessary(); // resize screen if necessary

            screen.clear();
            screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void draw() throws IOException {

        screen.clear();
        screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
    public void run() throws IOException {
        draw();
    }

    private void processKey(KeyStroke key) {
        System.out.println(key);
    }

}

