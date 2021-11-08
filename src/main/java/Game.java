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
    final public Screen screen = new TerminalScreen(terminal);
    final private Hero hero = new Hero(10,10);

    private void moveHero(Position position) {
        hero.setPosition(position);
    }

    private void processKey(KeyStroke key) {
        if (key.getKeyType()== KeyType.ArrowUp) {
            moveHero(hero.moveUp());
        } else if (key.getKeyType()== KeyType.ArrowDown) {
            moveHero(hero.moveDown());
        } else if (key.getKeyType()== KeyType.ArrowLeft) {
            moveHero(hero.moveLeft());
        } else if (key.getKeyType()== KeyType.ArrowRight) {
            moveHero(hero.moveRight());
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
        hero.draw(screen);
        screen.refresh();
    }
    public void run() throws IOException {
        draw();
        KeyStroke key= screen.readInput();
        while(key.getKeyType()!=KeyType.EOF) {
            if (key.getKeyType() == KeyType.Character && key.getCharacter()=='q') break;
            processKey(key);
            screen.clear();
            hero.draw(screen);
            screen.refresh();
            key = screen.readInput();
        }
        screen.close();
    }

}

