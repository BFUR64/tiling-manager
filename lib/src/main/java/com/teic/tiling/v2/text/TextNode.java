package com.teic.tiling.v2.text;

import com.teic.tiling.v2.interfaces.Renderable;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import io.github.bfur64.terminal.interfaces.TerminalBackend;
import org.jspecify.annotations.NullMarked;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@NullMarked
public class TextNode extends Node implements Renderable {
    private final Set<TextEntry> entries = new HashSet<>();

    public TextNode() {
        this(Position.of(0, 0), Size.of(0, 0));
    }

    public TextNode(Position desiredPosition, Size desiredSize) {
        super(desiredPosition, desiredSize);
    }

    public void put(int x, int y, String out) {
        put(x, y, () -> out);
    }

    public void put(int x, int y, Supplier<?> supplier) {
        entries.add(TextEntry.of(x, y, supplier));
    }

    @Override
    public void update() {
        int maxX = 0, maxY = 0;

        for (TextEntry entry : entries) {
            String text = String.valueOf(entry.supplier().get());
            maxX = Math.max(maxX, entry.position().x() + text.length());
            maxY = Math.max(maxY, entry.position().y() + 1);
        }

        desiredSize = Size.of(maxX, maxY);
    }

    @Override
    public void render(TerminalBackend terminal, Geometry finalGeometry) {
        Position offset = finalGeometry.position();
        Size constraint = finalGeometry.size();

        for (TextEntry textEntry : entries) {
            String out = String.valueOf(textEntry.supplier().get());

            // Y Clamp
            if (textEntry.position().y() > constraint.y()) continue;

            // X Clamp
            int clamped = Math.max(0, constraint.x() - textEntry.position().x());
            int end = Math.min(out.length(), clamped);
            out = out.substring(0, end);

            terminal.put(
                offset.x() + textEntry.position().x(),
                offset.y() + textEntry.position().y(),
                out
            );
        }
    }
}
