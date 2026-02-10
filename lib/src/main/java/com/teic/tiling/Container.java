package com.teic.tiling;

import java.util.List;
import java.util.ArrayList;

public class Container extends Layout {
    private final List<Row> rows = new ArrayList<>();

    public void render() {
        render(offsetX, offsetY);
    }

    @Override
    protected void render(int anchorX, int anchorY) {
        sizeX = 0;
        sizeY = 0;
        int totalRowHeight = 0;

        for (Row row : rows) {
            row.render(anchorX + offsetX, anchorY + offsetY, totalRowHeight);
            
            totalRowHeight += row.rowHeight;
            sizeX = Math.max(row.rowWidth, sizeX);
        }

        sizeY = totalRowHeight;
    }

    public void addChildren(Layout... children) {
        if (children.length == 0) {
            return;
        }

        rows.add(new Row());

        rows.getLast().addChildren(children);
    }

    public void addChildren(int y, Layout... children) {
        if (children.length == 0) {
            return;
        }

        while (rows.size() <= y) {
            rows.add(new Row());
        }

        rows.get(y).addChildren(children);
    }

    

    private class Row {
        private final List<Layout> children = new ArrayList<>();
        private int rowWidth = 0;
        private int rowHeight = 0;

        private void render(int anchorX, int anchorY, int prevTotalRowHeight) {
            rowWidth = 0;
            rowHeight = 0;

            for (Layout child : children) {
                int childAnchorX = anchorX + rowWidth;
                int childAnchorY = anchorY + prevTotalRowHeight;

                child.render(childAnchorX, childAnchorY);
                
                rowWidth += child.offsetX + child.sizeX;
                rowHeight = Math.max(child.offsetY + child.sizeY, rowHeight);
            }
        }

        private void addChildren(Layout... children) {
            for (Layout child : children) {
                this.children.add(child);
            }
        }
    }
}
