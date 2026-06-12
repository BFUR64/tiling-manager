package com.teic.tiling.v2.text;

import com.teic.tiling.v2.utils.Position;

import java.util.function.Supplier;

public record TextEntry(Position position, Supplier<?> supplier) {
    public static TextEntry of(int x, int y, Supplier<?> supplier) {
        return new TextEntry(Position.of(x, y), supplier);
    }
}
