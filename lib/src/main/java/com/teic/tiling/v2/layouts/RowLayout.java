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
public final class RowLayout implements Layout {
    public static final RowLayout INSTANCE = new RowLayout();

    private RowLayout() {}

    @Override
    public Size measure(Container container) {
        int x = 0;
        int y = 0;

        for (Node child : container.getChildren()) {
            Size size = child.getDesiredSize();

            x = Math.max(x, size.x());
            y += size.y();
        }

        return Size.of(x, y);
    }

    public Map<Node, Geometry> apply(Node node, Geometry parentGeometry) {
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
