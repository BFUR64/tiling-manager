package com.teic.tiling.v2.layouts;

import com.teic.tiling.v2.interfaces.Container;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Position;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public class RowLayout {
    public static Map<Node, Geometry> apply(Node node, Geometry parentGeometry) {
        Map<Node, Geometry> local = new HashMap<>();

        Position offset = parentGeometry.position();

        int x = offset.x();
        int y = offset.y();

        if (node instanceof Container parent) {
            for (Node child : parent.getChildren()) {
                Size size = child.getDesiredSize();

                Position finalPosition = Position.of(x, y);

                local.put(child, Geometry.of(finalPosition, size));

                y += size.y();
            }
        }

        return local;
    }
}
