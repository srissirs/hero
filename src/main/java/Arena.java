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


    private final int width;
    private final int height;
    final private Hero hero = new Hero(10,10);

    Arena(int width, int height){
        this.width=width;
        this.height=height;
    }

    public void draw(TextGraphics graphics) {
        hero.draw(graphics);
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }



   public boolean canHeroMove(Position position){
        return (position.getX()>=0 && position.getX() <= width) && (position.getY() <= height && position.getY() >=0);
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
