import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;


abstract public class Element {
    int x, y;
    Position position = new Position(x,y);

    Element() {
    }

    void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

}
class Hero extends Element {

    Hero(int x, int y){
        this.x=x;
        this.y=y;
        position.setX(x);
        position.setY(y);
    }


    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveRight() {
        return new Position(position.getX()+ 1, position.getY());
    }

    public Position moveLeft() {
        return new Position(position.getX()- 1, position.getY());
    }

    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

}

class Wall extends Element {
    Wall (int x,int y){
        this.x=x;
        this.y=y;
        position.setX(x);
        position.setY(y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(x, y), "|");
    }

}
