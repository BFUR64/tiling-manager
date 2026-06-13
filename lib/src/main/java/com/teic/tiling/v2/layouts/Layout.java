package com.teic.tiling.v2.layouts;

import com.teic.tiling.v2.interfaces.Container;
import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import com.teic.tiling.v2.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

@NullMarked
public interface Layout {
    Size measure(Container container);
    Map<Node, Geometry> apply (Node node, Geometry parentGeometry);
}
