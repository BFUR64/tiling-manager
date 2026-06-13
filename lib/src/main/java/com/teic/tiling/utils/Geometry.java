package com.teic.tiling.utils;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record Geometry(Position position, Size size) {
    public static Geometry of(Position position, Size size) {
        return new Geometry(position, size);
    }
}
