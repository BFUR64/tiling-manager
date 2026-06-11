package com.teic.tiling.v2.layouts;

import com.teic.tiling.v2.utils.Geometry;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

@NullMarked
public interface Layout {
    Map<Node, Geometry> apply (Node node);
}
