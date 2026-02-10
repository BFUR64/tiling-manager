package com.teic.tiling.singlelinetext;

import java.util.function.Supplier;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.teic.tiling.Layout;

public class DynamicLabel extends Layout {
    private final TextGraphics textGraphics;
    
    private String out;
    private Supplier<Object> supplier;
    
    public DynamicLabel(TextGraphics textGraphics) {
        this.textGraphics = textGraphics;
    }

    @Override
    protected void render(int anchorX, int anchorY) {
        String combinedOut = out + supplier.get();

        sizeX = 0;
        sizeX = Math.max(combinedOut.length(), sizeX);

        textGraphics.putString(
            anchorX + offsetX,
            anchorY + offsetY,
            combinedOut);
    }

    public void putLabel(String out, Supplier<Object> supplier) {
        sizeX = Math.max(out.length() + supplier.get().toString().length(), sizeX);
        sizeY = 1;

        this.out = out;
        this.supplier = supplier;
    }

    public void clear() {
        out = null;
        supplier = null;

        sizeX = 0;
        sizeY = 0;
    }
}
