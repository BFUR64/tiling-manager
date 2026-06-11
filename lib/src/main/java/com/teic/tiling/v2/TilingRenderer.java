package com.teic.tiling.v2;

import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.text.StaticEntry;
import com.teic.tiling.v2.text.StaticText;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import io.github.bfur64.terminal.interfaces.TerminalBackend;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

@NullMarked
public class TilingRenderer {
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

    private void draw (Node node, Geometry geometry) {
        if (node instanceof StaticText staticText) {
            for (StaticEntry e : staticText.getEntries()) {
                terminal.put(
                    geometry.position().x() + e.position().x(),
                    geometry.position().y() + e.position().y(),
                    e.out()
                );
            }
        }
    }
}
