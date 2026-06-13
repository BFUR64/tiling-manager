package com.teic.tiling.layouts;

import com.teic.tiling.interfaces.Container;
import com.teic.tiling.utils.Geometry;
import com.teic.tiling.utils.Node;
import com.teic.tiling.utils.Size;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

@NullMarked
public interface Layout {
    Size measure(Container container);
    Map<Node, Geometry> layout(Container parent, Geometry geometry);
}
