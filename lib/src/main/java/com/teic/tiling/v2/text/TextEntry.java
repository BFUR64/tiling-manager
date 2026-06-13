package com.teic.tiling.v2.text;

import com.teic.tiling.v2.utils.Position;

import java.util.function.Supplier;

public record TextEntry(Position position, Supplier<?> supplier) {
    public static TextEntry of(Position position, Supplier<?> supplier) {
        return new TextEntry(position, supplier);
    }
}
