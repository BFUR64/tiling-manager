package com.teic.tiling.v2.layouts;

import com.teic.tiling.v2.interfaces.Container;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public class AbsoluteLayout {
    public static Map<Node, Geometry> apply(Node node, Geometry parentGeometry) {
        Map<Node, Geometry> local = new HashMap<>();

        if (node instanceof Container parent) {
            for (Node child : parent.getChildren()) {
                local.put(child, Geometry.of(child.getDesiredPosition(), child.getDesiredSize()));
            }
        }

        return local;
    }
}
