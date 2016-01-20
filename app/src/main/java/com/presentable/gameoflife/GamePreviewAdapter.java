package com.presentable.gameoflife;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class GamePreviewAdapter extends BaseAdapter {
    private Grid grid;
    private Context context;

    public GamePreviewAdapter(Context context, Grid grid) {
        super();
        this.grid = grid;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GamePreview gamePreview;
        if (convertView == null) {
            gamePreview = new GamePreview(context);
        } else {
            gamePreview = (GamePreview) convertView;
        }

        gamePreview.setGrid(grid);
        return gamePreview;
    }
}
