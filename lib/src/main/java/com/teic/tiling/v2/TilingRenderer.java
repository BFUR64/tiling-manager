package com.teic.tiling.v2;

import com.teic.tiling.v2.interfaces.Renderable;
import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import io.github.bfur64.terminal.interfaces.TerminalBackend;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

@NullMarked
public final class TilingRenderer {
    private final TerminalBackend terminal;

    public TilingRenderer(TerminalBackend terminal) {
        this.terminal = terminal;
    }

    public void render(LayoutResult layoutResult) {
        for (Map.Entry<Node, Geometry> entry : layoutResult.finalLayout().entrySet()) {
            draw(entry.getKey(), entry.getValue());
        }

        terminal.flush();
    }

    private void draw(Node node, Geometry geometry) {
        if (node instanceof Renderable renderableNode) {
            renderableNode.render(terminal, geometry);
        }
    }
}
