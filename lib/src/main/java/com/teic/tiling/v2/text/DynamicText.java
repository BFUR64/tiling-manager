package com.teic.tiling.v2.text;

import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@NullMarked
public class DynamicText<T> extends Node {
    private final Set<DynamicEntry<T>> entries = new HashSet<>();
    private boolean dirty = true;

    public DynamicText(Position position, Size size) {
        super(position, size);
    }

    public void putString(int x, int y, Supplier<T> supplier) {
        entries.add(DynamicEntry.of(x, y, supplier));
        dirty = true;
    }

    @Override
    public void update() {
        if (dirty) {
            recalculateTotalSize();
            dirty = false;
        }
    }

    public Set<DynamicEntry<T>> getEntries() {
        return entries;
    }

    private void recalculateTotalSize() {
        int maxX = 0, maxY = 0;

        for (DynamicEntry<T> entry : entries) {
            String text = entry.supplier().get().toString();
            maxX = Math.max(maxX, entry.position().x() + text.length());
            maxY = Math.max(maxY, entry.position().y() + 1);
        }

        desiredSize = Size.of(maxX, maxY);
    }
}
