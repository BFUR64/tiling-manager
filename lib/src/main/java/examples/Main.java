package examples;

import com.teic.tiling.v2.Container;
import com.teic.tiling.v2.Engine;
import com.teic.tiling.v2.Render;
import com.teic.tiling.v2.layouts.AbsoluteLayout;
import com.teic.tiling.v2.text.StaticText;
import io.github.bfur64.terminal.BufferedTerminal;
import io.github.bfur64.terminal.interfaces.TerminalBackend;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class Main {
    private final TerminalBackend terminal;

    public Main(TerminalBackend terminal) {
        this.terminal = terminal;
    }

    public static void main(String[] args) {
        try (TerminalBackend terminal = BufferedTerminal.auto()) {
            terminal.start();
            Main app = new Main(terminal);
            app.start();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void start() {
        StaticText firstTextBox = new StaticText();
        firstTextBox.putString(0, 0, "Hello World!");
        firstTextBox.putString(0, 1, "I am Terrance!");

        Container root = new Container(new AbsoluteLayout(), List.of(
            firstTextBox
        ));

        Render render = new Render(terminal);
        Engine engine = new Engine(render, new AbsoluteLayout(), root);
        engine.start();
        terminal.readInput();
    }
}
