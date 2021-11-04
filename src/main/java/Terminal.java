import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.TerminalResizeListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Terminal implements com.googlecode.lanterna.terminal.Terminal {
    @Override
    public void enterPrivateMode() throws IOException {

    }

    @Override
    public void exitPrivateMode() throws IOException {

    }

    @Override
    public void clearScreen() throws IOException {

    }

    @Override
    public void setCursorPosition(int x, int y) throws IOException {

    }

    @Override
    public void setCursorPosition(TerminalPosition position) throws IOException {

    }

    @Override
    public TerminalPosition getCursorPosition() throws IOException {
        return null;
    }

    @Override
    public void setCursorVisible(boolean visible) throws IOException {

    }

    @Override
    public void putCharacter(char c) throws IOException {

    }

    @Override
    public void putString(String string) throws IOException {

    }

    @Override
    public TextGraphics newTextGraphics() throws IOException {
        return null;
    }

    @Override
    public void enableSGR(SGR sgr) throws IOException {

    }

    @Override
    public void disableSGR(SGR sgr) throws IOException {

    }

    @Override
    public void resetColorAndSGR() throws IOException {

    }

    @Override
    public void setForegroundColor(TextColor color) throws IOException {

    }

    @Override
    public void setBackgroundColor(TextColor color) throws IOException {

    }

    @Override
    public void addResizeListener(TerminalResizeListener listener) {

    }

    @Override
    public void removeResizeListener(TerminalResizeListener listener) {

    }

    @Override
    public TerminalSize getTerminalSize() throws IOException {
        return null;
    }

    @Override
    public byte[] enquireTerminal(int timeout, TimeUnit timeoutUnit) throws IOException {
        return new byte[0];
    }

    @Override
    public void bell() throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public KeyStroke pollInput() throws IOException {
        return null;
    }

    @Override
    public KeyStroke readInput() throws IOException {
        return null;
    }
}
