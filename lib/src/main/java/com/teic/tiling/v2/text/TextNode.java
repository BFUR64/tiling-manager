package com.teic.tiling.v2.text;

import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class TextNode extends Node {
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

    public Set<TextEntry> getEntries() {
        return entries;
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
}
