package com.teic.tiling.v2.utils;

import org.jspecify.annotations.NullMarked;

@NullMarked
public abstract class Node {
    protected Position desiredPosition;
    protected Size desiredSize;

    public Node(Position desiredPosition, Size desiredSize) {
        this.desiredPosition = desiredPosition;
        this.desiredSize = desiredSize;
    }

    public void update() {}

    public Position getDesiredPosition()  {
        return desiredPosition;
    }

    public Size getDesiredSize() {
        return desiredSize;
    }
}
