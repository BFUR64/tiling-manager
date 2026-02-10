package com.teic.tiling;

public abstract class Layout {
    protected int sizeX;
    protected int sizeY;

    protected int offsetX;
    protected int offsetY;

    protected abstract void render(int anchorX, int anchorY);

    public void setOffset(int x, int y) {
        offsetX = x;
        offsetY = y;
    }
}
