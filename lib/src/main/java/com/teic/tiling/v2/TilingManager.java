package com.teic.tiling.v2;

import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class TilingManager {
    private final TilingRenderer render;
    private final Node root;

    public TilingManager(TilingRenderer render, Node root) {
        this.render = render;
        this.root = root;
    }

    public void tick() {
        update();
        LayoutResult result = layout();
        render(result);
    }

    private void update() {
        root.update();
    }

    private LayoutResult layout() {
        return LayoutManager.apply(root);
    }

    private void render(LayoutResult result) {
        render.render(result);
    }
}
