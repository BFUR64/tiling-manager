package com.teic.tiling.interfaces;

import com.teic.tiling.layouts.Layout;
import com.teic.tiling.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public interface Container {
    List<Node> getChildren();
    Layout getLayout();
}
