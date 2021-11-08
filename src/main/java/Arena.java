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

public class Arena {

    private int width;
    private int height;
    final private Hero hero = new Hero(10,10);

    Arena(int width, int height){
        this.width=width;
        this.height=height;
    }

    public void draw(Screen screen) {
        hero.draw(screen);
    }
   public boolean canHeroMove(Position position){
       return position.getX() <= width && position.getY() <= height;
   }

    private void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    public void processKey(KeyStroke key) {
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

}
