package com.teic.tiling.v2;

import com.teic.tiling.v2.layouts.Layout;
import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class Engine {
    private final Render render;
    private final Layout layout;
    private final Node root;
    private LayoutResult layoutResult;

    public Engine(Render render, Layout layout, Node root) {
        this.render = render;
        this.layout = layout;
        this.root = root;
        this.layoutResult = layout.apply(root);
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
        layoutResult = layout.apply(root);
    }

    private void render() {
        render.render(layoutResult);
    }
}
