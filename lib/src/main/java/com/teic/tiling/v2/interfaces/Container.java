package com.teic.tiling.v2.interfaces;

import com.teic.tiling.v2.layouts.Layout;
import com.teic.tiling.v2.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public interface Container {
    List<Node> getChildren();
    Layout getLayout();
}
