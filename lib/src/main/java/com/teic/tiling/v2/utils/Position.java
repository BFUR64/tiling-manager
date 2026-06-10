package com.teic.tiling.v2.utils;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record Position(int x, int y) {
    public static Position of(int x, int y) {
        return new Position(x, y);
    }
}
