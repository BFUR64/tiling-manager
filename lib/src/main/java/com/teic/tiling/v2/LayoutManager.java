package com.teic.tiling.v2;

import com.teic.tiling.v2.interfaces.Container;
import com.teic.tiling.v2.layouts.LayoutResult;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public class LayoutManager {
    public static LayoutResult apply(Node node, Position offset, Size size) {
        Map<Node, Geometry> result = new HashMap<>();

        walk(node, result, Geometry.of(offset, size));

        return new LayoutResult(result);
    }

    private static void walk(Node node, Map<Node, Geometry> result, Geometry parentGeometry) {
        if (node instanceof Container container) {
            Map<Node, Geometry> childGeometry = container.getLayout().apply(node, parentGeometry);
            result.putAll(childGeometry);

            for (Node child : container.getChildren()) {
                walk(child, result, childGeometry.get(child));
            }
        }
    }
}
