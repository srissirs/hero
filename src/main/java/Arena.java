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
import java.util.ArrayList;
import java.util.List;

public class Arena {

    private final int width, height;
    public final List<Wall> walls;
    final private Hero hero = new Hero(10,10);


    Arena(int width, int height){
        this.width=width;
        this.height=height;
        this.walls = createWalls();

    }

    public void draw(TextGraphics graphics) {
        hero.draw(graphics);
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

   public boolean canHeroMove(Position position){
       for (Wall wall : walls)
           if (wall.getPosition().equals(position)) return false;
       return (position.getX()>=0 && position.getX() < width) && (position.getY() < height && position.getY() >=0);
   }

    private void moveHero(Position position) {
       // System.out.println(position.getX());
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
        System.out.println(hero.getPosition().getX());
        System.out.println(hero.getPosition().getY());
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

}
