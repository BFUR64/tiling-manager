package com.teic.tiling.multilinetext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.teic.tiling.Layout;

import com.googlecode.lanterna.graphics.TextGraphics;

public class DynamicText extends Layout {
    private final TextGraphics textGraphics;

    private final List<DynamicEntryText> entries = new ArrayList<>();


    public DynamicText(TextGraphics textGraphics) {
        this.textGraphics = textGraphics;
    }

    @Override
    protected void render(int anchorX, int anchorY) {
        sizeX = 0;

        for (DynamicEntryText entry : entries) {
            String combinedOut = entry.out + entry.supplier.get();

            sizeX = Math.max(combinedOut.length(), sizeX);

            textGraphics.putString(
                entry.x + anchorX + offsetX,
                entry.y + anchorY + offsetY,
                combinedOut);
        }
    }

    public void putString(int x, int y, String out, Supplier<Object> supplier) {
        sizeX = Math.max(out.length() + supplier.get().toString().length(), sizeX);
        sizeY = Math.max(y + 1, sizeY);

        for (DynamicEntryText entry : entries) {
            if (entry.x == x && entry.y == y) {
                entry.out = out;
                entry.supplier = supplier;
                return;
            }
        }

        entries.add(new DynamicEntryText(x, y, out, supplier));
    }

    public void clear() {
        entries.clear();

        sizeX = 0;
        sizeY = 0;
    }

    private class DynamicEntryText {
        private int x;
        private int y;
        private String out;
        private Supplier<Object> supplier;

        private DynamicEntryText(int x, int y, String out, Supplier<Object> supplier) {
            this.x = x;
            this.y = y;
            this.out = out;
            this.supplier = supplier;
        }
    }
}
