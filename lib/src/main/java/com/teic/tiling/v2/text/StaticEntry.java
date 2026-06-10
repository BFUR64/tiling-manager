package com.teic.tiling.v2.text;

import com.teic.tiling.v2.utils.Position;
import org.jspecify.annotations.NullMarked;

@NullMarked
public record StaticEntry(Position position, String out) {
    public static StaticEntry of(int x, int y, String out) {
        return new StaticEntry(Position.of(x, y), out);
    }
}
