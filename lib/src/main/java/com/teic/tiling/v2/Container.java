package com.teic.tiling.v2;

import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public class Container extends Node {
    private final List<Node> nodes;

    public Container(List<Node> nodes) {
        this(Position.of(0, 0), Size.of(0, 0), nodes);
    }

    public Container(Position position, Size size, List<Node> nodes) {
        super(position, size);
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
}
