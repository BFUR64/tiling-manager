package com.teic.tiling.v2;

import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

@NullMarked
public class Engine {
    private final Render render;
    private final Node root;
    private final LayoutManager layoutManager;
    private @Nullable LayoutResult layoutResult;

    public Engine(Render render, Node root) {
        this.render = render;
        this.root = root;
        this.layoutManager = new LayoutManager();
    }

    public void start() {
        update();
        layout();
        render();
    }

    private void update() {
        root.update();
    }

    private void layout() {
        layoutResult = layoutManager.apply(root);
    }

    private void render() {
        assert layoutResult != null;
        render.render(layoutResult);
    }
}
