package com.teic.tiling.v2;

import com.teic.tiling.v2.interfaces.hasChildren;
import com.teic.tiling.v2.interfaces.hasLayout;
import com.teic.tiling.v2.layouts.Layout;
import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class Container extends Node implements hasChildren, hasLayout {
    private final List<Node> nodes;
    private final Layout layout;

    public Container(Layout layout, List<Node> nodes) {
        this(Position.of(0, 0), Size.of(0, 0), layout, nodes);
    }

    public Container(Position position, Size size, Layout layout, List<Node> nodes) {
        super(position, size);
        this.layout = layout;
        this.nodes = nodes;
    }

    @Override
    public void update() {
        for (Node node : nodes) {
            node.update();
        }
    }

    @Override
    public List<Node> getChildren() {
        return nodes;
    }

    @Override
    public Layout getLayout() {
        return layout;
    }
}
