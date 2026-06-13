package com.teic.tiling.v2;

import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import io.github.bfur64.terminal.interfaces.TerminalBackend;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class Viewport {
    private final TerminalBackend terminal;
    private final TilingRenderer render;
    private final ContainerNode root;

    private Position offset;
    private Size size;

    private boolean autoResize;

    public Viewport(TerminalBackend terminal, ContainerNode root) {
        this.terminal = terminal;
        this.render = new TilingRenderer(terminal);
        this.root = root;

        this.offset = Position.of(0, 0);
        size = Size.of(terminal.getXSize(), terminal.getYSize());
    }

    public void tick() {
        update();
        measure();
        LayoutResult result = layout();
        render(result);
    }

    public void setOffset(Position offset) {
        this.offset = offset;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setAutoResize(boolean autoResize) {
        this.autoResize = autoResize;
    }

    public void resizeToTerminal() {
        size = Size.of(terminal.getXSize(), terminal.getYSize());
    }

    private void update() {
        root.update();
    }

    private void measure() {
        root.measure();
    }

    private LayoutResult layout() {
        if (autoResize) resizeToTerminal();

        return LayoutManager.apply(root, Geometry.of(offset, size));
    }

    private void render(LayoutResult result) {
        render.render(result);
    }
}
