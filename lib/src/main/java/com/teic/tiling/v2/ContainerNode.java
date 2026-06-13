package com.teic.tiling.v2;

import com.teic.tiling.v2.interfaces.Container;
import com.teic.tiling.v2.layouts.Layout;
import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class ContainerNode extends Node implements Container {
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
