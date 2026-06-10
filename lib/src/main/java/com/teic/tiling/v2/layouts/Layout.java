package com.teic.tiling.v2.layouts;

import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface Layout {
    LayoutResult apply (Node node);
}
