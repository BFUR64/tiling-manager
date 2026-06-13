package com.teic.tiling.layouts;

import com.teic.tiling.interfaces.Container;
import com.teic.tiling.utils.Geometry;
import com.teic.tiling.utils.Node;
import com.teic.tiling.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.HashMap;
import java.util.Map;

@NullMarked
public final class AbsoluteLayout implements Layout {
    public static final Layout INSTANCE = new AbsoluteLayout();

    private AbsoluteLayout() {}

    @Override
    public Size measure(Container container) {
        int x = 0;
        int y = 0;

        for (Node child : container.getChildren()) {
            Size size = child.getDesiredSize();

            x = Math.max(x, size.x());
            y = Math.max(y, size.y());
        }

        return Size.of(x, y);
    }

    @Override
    public Map<Node, Geometry> layout(Container parent, Geometry geometry) {
        Map<Node, Geometry> local = new HashMap<>();

        for (Node child : parent.getChildren()) {
            local.put(child, Geometry.of(child.getDesiredPosition(), child.getDesiredSize()));
        }

        return local;
    }
}
