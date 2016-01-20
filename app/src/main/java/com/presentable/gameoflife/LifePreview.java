package com.presentable.gameoflife;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class LifePreview {
    static final int ALIVE = 1;
    static final int DEAD = 0;

    static int CELL_SIZE;
    static int HEIGHT;
    static int WIDTH;

    private static int[][] previewGrid;

    public LifePreview(Context context, Grid grid) {
        DisplayMetrics mdisplayMetrics = context.getResources().getDisplayMetrics();
        CELL_SIZE = mdisplayMetrics.widthPixels / 5;
        HEIGHT = mdisplayMetrics.widthPixels / CELL_SIZE;
        WIDTH = mdisplayMetrics.widthPixels / CELL_SIZE;

        previewGrid = new int[HEIGHT][WIDTH];

        initializeGrid(grid);
    }

    public static int[][] getPreviewGrid() {
        return previewGrid;
    }

    //sets default grid to begin with
    private void initializeGrid(Grid grid) {
        for (Pair<Integer, Integer> coord : grid.getCoords()) {
            setGrid(coord);
        }
    }

    private void setGrid(Pair<Integer, Integer> coord) {
        previewGrid[coord.first][coord.second] = ALIVE;
    }

}
