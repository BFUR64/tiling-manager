package com.teic.tiling.singlelinetext;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.teic.tiling.Layout;

public class StaticLabel extends Layout {
    protected final TextGraphics textGraphics;
    
    protected String out;

    public StaticLabel(TextGraphics textGraphics) {
        this.textGraphics = textGraphics;
    }

    @Override
    protected void render(int anchorX, int anchorY) {
        textGraphics.putString(
            anchorX + offsetX,
            anchorY + offsetY,
            out);
    }

    public void putLabel(String out) {
        sizeX = Math.max(out.length(), sizeX);
        sizeY = 1;

        this.out = out;
    }
}
