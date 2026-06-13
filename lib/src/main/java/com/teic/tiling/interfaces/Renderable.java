package com.teic.tiling.interfaces;

import com.teic.tiling.utils.Geometry;
import io.github.bfur64.terminal.interfaces.TerminalBackend;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Renderable {
    void render(TerminalBackend terminal, Geometry finalGeometry);
}
