package com.teic.tiling;

import com.teic.tiling.interfaces.Container;
import com.teic.tiling.layouts.Layout;
import com.teic.tiling.utils.Node;
import com.teic.tiling.utils.Position;
import com.teic.tiling.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public final class ContainerNode extends Node implements Container {
    private final List<Node> nodes;
    private final Layout layout;

    public ContainerNode(Layout layout, List<Node> nodes) {
        this(Position.of(0, 0), Size.of(0, 0), layout, nodes);
    }

    public ContainerNode(Position position, Size size, Layout layout, List<Node> nodes) {
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
    public void measure() {
        for (Node node : nodes) {
            node.measure();
        }

        desiredSize = layout.measure(this);
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
