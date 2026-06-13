package examples;

import com.teic.tiling.Container;
import com.teic.tiling.v2.ContainerNode;
import com.teic.tiling.v2.Viewport;
import com.teic.tiling.v2.layouts.ColumnLayout;
import com.teic.tiling.v2.layouts.RowLayout;
import com.teic.tiling.v2.text.TextNode;
import com.teic.tiling.v2.utils.Node;
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
        firstTextBox.put(3, 1, "Text Box1");

        TextNode secondTextBox = new TextNode();
        secondTextBox.put(3, 1, "Text Box2");

        TextNode thirdTextBox = new TextNode();
        thirdTextBox.put(3, 1, "Text Box3");

        TextNode fourthTextBox = new TextNode();
        fourthTextBox.put(3, 1, "Text Box444");

        TextNode fifthTextBox = new TextNode();
        fifthTextBox.put(3, 1, "Text Box5");

        TextNode sixthTextBox = new TextNode();
        sixthTextBox.put(3, 1, "Text Box6");

        Node rowBitch = new ContainerNode(RowLayout.INSTANCE, List.of(
            fifthTextBox,
            sixthTextBox
        ));

        Node anothaOne = new ContainerNode(ColumnLayout.INSTANCE, List.of(
            firstTextBox,
            secondTextBox
//            rowBitch
        ));

        ContainerNode root = new ContainerNode(RowLayout.INSTANCE, List.of(
            thirdTextBox,
            anothaOne,
            fourthTextBox
        ));

        Viewport viewport = new Viewport(terminal, root);
        viewport.setAutoResize(true);
        viewport.tick();
        terminal.readInput();
    }
}
