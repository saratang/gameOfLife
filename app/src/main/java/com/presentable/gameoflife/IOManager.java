package com.presentable.gameoflife;

import android.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class IOManager {
    static List<Grid> startingPositionsSet = new ArrayList<>();

    public static void addStartingPositions() {
        Set<Coords> coords1 = new HashSet<>();
        coords1.add(new Coords(0, 1));
        coords1.add(new Coords(0, 3));
        coords1.add(new Coords(1, 1));
        coords1.add(new Coords(1, 3));
        coords1.add(new Coords(2, 1));
        coords1.add(new Coords(2, 2));
        coords1.add(new Coords(2, 3));

        Grid grid1 = new Grid(5, 5, coords1);
        startingPositionsSet.add(grid1);

        Set<Coords> coords2 = new HashSet<>();
        coords2.add(new Coords(1, 1));
        coords2.add(new Coords(2, 2));
        coords2.add(new Coords(2, 3));
        coords2.add(new Coords(3, 1));
        coords2.add(new Coords(3, 2));

        Grid grid2 = new Grid(5, 5, coords2);
        startingPositionsSet.add(grid2);
    }
}
