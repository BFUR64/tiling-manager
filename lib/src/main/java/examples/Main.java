package examples;

import com.teic.tiling.v2.ContainerNode;
import com.teic.tiling.v2.Viewport;
import com.teic.tiling.v2.layouts.AbsoluteLayout;
import com.teic.tiling.v2.text.TextNode;
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
        TextNode firstTextBox = new TextNode();
        firstTextBox.put(0, 0, "Hello World!");
        firstTextBox.put(0, 1, "I am Terrance!");

        ContainerNode root = new ContainerNode(AbsoluteLayout::apply, List.of(
            firstTextBox
        ));

        Viewport viewport = new Viewport(terminal, root);
        viewport.setAutoResize(true);
        viewport.tick();
        terminal.readInput();
    }
}
