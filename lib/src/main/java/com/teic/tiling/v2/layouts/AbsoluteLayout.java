package com.teic.tiling.v2.layouts;

import com.teic.tiling.v2.interfaces.hasChildren;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public class AbsoluteLayout implements Layout {
    @Override
    public Map<Node, Geometry> apply(Node node) {
        Map<Node, Geometry> local = new HashMap<>();

        if (node instanceof hasChildren parent) {
            for (Node child : parent.getChildren()) {
                local.put(child, new Geometry(child.getDesiredPosition(), child.getDesiredSize()));
            }
        }

        return local;
    }
}
