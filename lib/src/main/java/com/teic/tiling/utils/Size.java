package com.teic.tiling.utils;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record Size(int x, int y) {
    public static Size of(int x, int y) {
        return new Size(x, y);
    }
}
