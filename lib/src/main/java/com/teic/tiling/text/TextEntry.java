package com.teic.tiling.text;

import com.teic.tiling.utils.Position;

import java.util.function.Supplier;

public record TextEntry(Position position, Supplier<?> supplier) {
    public static TextEntry of(Position position, Supplier<?> supplier) {
        return new TextEntry(position, supplier);
    }
}
