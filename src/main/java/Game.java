import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TabBehaviour;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Game {
    final private Terminal terminal = new DefaultTerminalFactory().createTerminal();
    final private Screen screen = new TerminalScreen(terminal);

    private int x = 10;
    private int y = 10;

    private void processKey(KeyStroke key) {
        if (key.getKeyType()== KeyType.ArrowUp) {
            y -= 1;
        } else if (key.getKeyType()== KeyType.ArrowDown) {
            y += 1;
        } else if (key.getKeyType()== KeyType.ArrowLeft) {
            x -= 1;
        } else if (key.getKeyType()== KeyType.ArrowRight) {
            x += 1;
        }
        System.out.println(key);
    }



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
        KeyStroke key= screen.readInput();;
        while(key.getKeyType()!=KeyType.EOF) {
            if (key.getKeyType() == KeyType.Character && key.getCharacter()=='q') break;
            processKey(key);
            screen.clear();
            screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
            key = screen.readInput();
        }
        screen.close();
    }

}

