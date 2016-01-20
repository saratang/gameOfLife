package com.presentable.gameoflife;

import android.util.Pair;

import java.io.Serializable;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class Coords extends Pair<Integer, Integer> implements Serializable {
    public Coords(Integer first, Integer second) {
        super(first, second);
    }
}
