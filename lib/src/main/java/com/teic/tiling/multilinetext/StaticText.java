package com.teic.tiling.multilinetext;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.teic.tiling.Layout;

public class StaticText extends Layout {
    private final TextGraphics textGraphics;
    
    private final List<StaticTextEntry> entries = new ArrayList<>();

    public StaticText(TextGraphics textGraphics) {
        this.textGraphics = textGraphics;
    }

    @Override
    protected void render(int anchorX, int anchorY) {
        for (StaticTextEntry entry : entries) {
            textGraphics.putString(
                entry.x + anchorX + offsetX,
                entry.y + anchorY + offsetY,
                entry.out);
        }
    }

    public void putString(int x, int y, String out) {
        sizeX = Math.max(x + out.length(), sizeX);
        sizeY = Math.max(y + 1, sizeY);

        for (StaticTextEntry entry : entries) {
            if (entry.x == x && entry.y == y) {
                entry.out = out;
                return;
            }
        }

        entries.add(new StaticTextEntry(x, y, out));
    }

    private class StaticTextEntry {
        private int x;
        private int y;
        private String out;

        private StaticTextEntry(int x, int y, String out) {
            this.x = x;
            this.y = y;
            this.out = out;
        }
    }
}
