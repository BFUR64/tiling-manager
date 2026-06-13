package com.teic.tiling;

import com.teic.tiling.interfaces.Container;
import com.teic.tiling.layouts.LayoutResult;
import com.teic.tiling.utils.Geometry;
import com.teic.tiling.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public final class LayoutManager {
    public static LayoutResult apply(Container container, Geometry parentGeometry) {
        Map<Node, Geometry> result = new HashMap<>();

        walk(container, result, parentGeometry);

        return new LayoutResult(result);
    }

    private static void walk(Container container, Map<Node, Geometry> result, Geometry parentGeometry) {
        Map<Node, Geometry> childGeometry = container.getLayout().layout(container, parentGeometry);
        result.putAll(childGeometry);

        for (Node child : container.getChildren()) {
            if (child instanceof Container childContainer) {
                walk(childContainer, result, childGeometry.get(child));
            }
        }
    }
}
