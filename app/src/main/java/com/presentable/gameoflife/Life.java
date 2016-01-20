package com.presentable.gameoflife;

import android.content.Context;
import android.util.DisplayMetrics;

import java.util.Random;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class Life {
    static final int ALIVE = 1;
    static final int DEAD = 0;
    static final int CELL_SIZE = 16;
    static int HEIGHT;
    static int WIDTH;

    private static int[][] gameGrid;

    public Life(Context context) {
        DisplayMetrics mdisplayMetrics = context.getResources().getDisplayMetrics();
        HEIGHT = mdisplayMetrics.heightPixels / CELL_SIZE;
        WIDTH = mdisplayMetrics.widthPixels / CELL_SIZE;

        gameGrid = new int[HEIGHT][WIDTH];

        initializeGrid();
    }

    public static int[][] getGameGrid() {
        return gameGrid;
    }

    //sets default grid to begin with
    private void initializeGrid() {
        gameGrid[(HEIGHT / 2) - 1][(WIDTH / 2) - 1] = 1;
        gameGrid[(HEIGHT / 2) - 1][(WIDTH / 2) + 1] = 1;
        gameGrid[(HEIGHT / 2)][(WIDTH / 2) - 1] = 1;
        gameGrid[(HEIGHT / 2)][(WIDTH / 2) + 1] = 1;
        gameGrid[(HEIGHT / 2) + 1][(WIDTH / 2) - 1] = 1;
        gameGrid[(HEIGHT / 2) + 1][(WIDTH / 2)] = 1;
        gameGrid[(HEIGHT / 2) + 1][(WIDTH / 2) + 1] = 1;
    }

    public void generateNext() {
        int[][] nextGrid = new int[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int numNeighbours = countNeighbours(i, j);
                if (gameGrid[i][j] == ALIVE) {
                    switch (numNeighbours) {
                        case 0: case 1:
                            nextGrid[i][j] = DEAD;
                            break;
                        case 2: case 3:
                            nextGrid[i][j] = ALIVE;
                            break;
                        case 4: case 5: case 6: case 7:case 8:
                            nextGrid[i][j] = DEAD;
                            break;
                        default:
                            break;
                    }
                } else { //gameGrid[i][j] == DEAD
                    //TODO: Develop a better algorithm to revive
                    switch (numNeighbours) {
                        case 3:
                            nextGrid[i][j] = ALIVE;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        copyGrid(nextGrid, gameGrid);
    }

    private int countNeighbours(int i, int j) {
        int count = 0;
        for (int h = -1; h <= 1; h++) {
            for (int k = -1; k <= 1; k++) {
                int neighbour = gameGrid[(HEIGHT + i + h) % HEIGHT][(WIDTH + j + k) % WIDTH];
                if ((h != 0 || k != 0) && neighbour == ALIVE) {
                    count++;
                }
            }
        }
        return count;
    }

    private void copyGrid(int[][] source, int[][] dest) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                dest[i][j] = source[i][j];
            }
        }
    }
}
