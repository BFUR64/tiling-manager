package com.teic.tiling.v2.interfaces;

import com.teic.tiling.v2.utils.Position;
import io.github.bfur64.terminal.interfaces.TerminalBackend;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Renderable {
    void render(TerminalBackend terminal, Position offset);
}
