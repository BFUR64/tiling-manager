package com.teic.tiling.v2;

import com.teic.tiling.v2.interfaces.Container;
import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public class LayoutManager {
    public static LayoutResult apply(Node node) {
        Map<Node, Geometry> result = new HashMap<>();

        walk(node, result);

        return new LayoutResult(result);
    }

    private static void walk(Node node, Map<Node, Geometry> result) {
        if (node instanceof Container container) {
            result.putAll(container.getLayout().apply(node));

            for (Node child : container.getChildren()) {
                walk(child, result);
            }
        }
    }
}
