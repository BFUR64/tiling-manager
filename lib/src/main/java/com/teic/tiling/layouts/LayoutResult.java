package com.teic.tiling.layouts;

import com.teic.tiling.utils.Geometry;
import com.teic.tiling.utils.Node;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

@NullMarked
public record LayoutResult(Map<Node, Geometry> finalLayout) {}
