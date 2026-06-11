package com.teic.tiling.v2;

import com.teic.tiling.v2.interfaces.hasChildren;
import com.teic.tiling.v2.interfaces.hasLayout;
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
        if (node instanceof hasLayout layout) {
            result.putAll(layout.getLayout().apply(node));
        }

        if (node instanceof hasChildren parent) {
            for (Node child : parent.getChildren()) {
                walk(child, result);
            }
        }
    }
}
