package com.teic.tiling.v2.text;

import com.teic.tiling.v2.utils.Position;
import org.jspecify.annotations.NullMarked;

import java.util.function.Supplier;

@NullMarked
public record DynamicEntry<T>(Position position, Supplier<T> supplier) {
    public static <T> DynamicEntry<T> of(int x, int y, Supplier<T> supplier) {
        return new DynamicEntry<>(new Position(x, y), supplier);
    }
}
