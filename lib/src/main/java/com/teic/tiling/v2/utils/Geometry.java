package com.teic.tiling.v2.utils;

import org.jspecify.annotations.NullMarked;

@NullMarked
public record Geometry(Position position, Size size) {
    public static Geometry of(Position position, Size size) {
        return new Geometry(position, size);
    }
}
