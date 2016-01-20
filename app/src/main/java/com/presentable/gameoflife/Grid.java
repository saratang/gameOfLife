package com.presentable.gameoflife;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class Grid implements Serializable {
//    private static final long serialVersionUID = 0L;

    private int height;
    private int width;
    private Set<Coords> coords;

    public Grid(int height, int width, Set<Coords> coords) {
        this.height = height;
        this.width = width;
        this.coords = coords;
    }

    public Set<Coords> getCoords() {
        return coords;
    }
}
