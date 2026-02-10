package com.teic.tiling.multilinetext;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.teic.tiling.Layout;

public class DynamicTextWrap extends Layout {
    private final TextGraphics textGraphics;

    private final List<StaticEntryText> entries = new ArrayList<>();
    
    private Supplier<Object> supplier;
    private int rightPadding;
    private int maxWidth;

    public DynamicTextWrap(TextGraphics textGraphics) {
        this.textGraphics = textGraphics;
    }

    @Override
    protected void render(int anchorX, int anchorY) {
        clearLines();

        updateWrapText(anchorX);

        for (StaticEntryText entry : entries) {
            sizeX = Math.max(entry.out.length(), sizeX);

            textGraphics.putString(
                entry.x + anchorX + offsetX,
                entry.y + anchorY + offsetY,
                entry.out);
        }
    }

    public void putString(Supplier<Object> supplier, int rightPadding, int maxWidth) {
        this.supplier = supplier;
        this.rightPadding = rightPadding;
        this.maxWidth = maxWidth;
   }

    public void clear() {
        entries.clear();

        supplier = null;
        rightPadding = 0;
        maxWidth = 0;

        sizeX = 0;
        sizeY = 0;
    }

    private void clearLines() {
        entries.clear();

        sizeX = 0;
        sizeY = 0;
    }

    private void updateWrapText(int anchorX) {
        List<String> lines = wrapText(anchorX);
        
        int yCounter = 0;
        for (String line : lines) {
            entries.add(new StaticEntryText(0, yCounter, line));
            sizeX = Math.max(line.length(), sizeX);
            yCounter++;
        }

        sizeY = lines.size();
    }

    private List<String> wrapText(int anchorX) {
        List<String> lines = new ArrayList<>();
        
        String[] words = supplier.get().toString().split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + (currentLine.length() > 0 ? 1 : 0) > maxWidth - rightPadding - anchorX) {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            }
            else {
                if (currentLine.length() > 0) {
                    currentLine.append(' ');
                }

                currentLine.append(word);
            }
        }

        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }

        return lines;
    }

    private class StaticEntryText {
        private int x;
        private int y;
        private String out;

        private StaticEntryText(int x, int y, String out) {
            this.x = x;
            this.y = y;
            this.out = out;
        }
    }
}
