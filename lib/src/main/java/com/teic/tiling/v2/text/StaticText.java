package com.teic.tiling.v2.text;

import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.HashSet;
import java.util.Set;

@NullMarked
public class StaticText extends Node {
    private final Set<StaticEntry> entries = new HashSet<>();

    public StaticText() {
        super(Position.of(0, 0), Size.of(0, 0));
    }

    public StaticText(Position position, Size size) {
        super(position, size);
    }

    public void putString(int x, int y, String out) {
        desiredSize = Size.of(
            Math.max(x + out.length(), desiredSize.x()),
            Math.max(y + 1, desiredSize.y())
        );

        StaticEntry newEntry = StaticEntry.of(x, y, out);

        entries.add(newEntry);
    }

    public Set<StaticEntry> getEntries() {
        return entries;
    }
}
