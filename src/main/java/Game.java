import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
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
    final private Arena arena = new Arena(15,15);
    public TextGraphics graphics = screen.newTextGraphics();

    /*
    private void moveHero(Position position) {
        hero.setPosition(position);
    }

     */

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
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(arena.getWidth(), arena.getHeight()), ' ');
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }


    public void run() throws IOException {
        draw();
        KeyStroke key= screen.readInput();
        while(key.getKeyType()!=KeyType.EOF) {
            if (key.getKeyType() == KeyType.Character && key.getCharacter()=='q') break;
            arena.processKey(key);
            draw();
            key = screen.readInput();
        }
        screen.close();
    }



}

