package com.teic.tiling.v2.layouts;

import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public class AbsoluteLayout implements Layout {
    @Override
    public LayoutResult apply(Node node) {
        Map<Node, Geometry> finalLayout = new HashMap<>();

        walk(node, finalLayout);

        return new LayoutResult(finalLayout);
    }

    private void walk(Node node, Map<Node, Geometry> finalLayout) {
        finalLayout.put(node, new Geometry(node.getDesiredPosition(), node.getDesiredSize()));

        for (Node child : node.getChildren()) {
            walk(child, finalLayout);
        }
    }
}
