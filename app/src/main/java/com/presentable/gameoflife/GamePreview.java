package com.presentable.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class GamePreview extends View {
    private LifePreview _life;
    private Context context;

    public GamePreview(Context context) {
        super(context);
        this.context = context;
    }

    public GamePreview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        _life = new LifePreview(context, IOManager.startingPositionsSet.get(0));
        initGameView();
    }

    public void setGrid(Grid grid) {
        _life = new LifePreview(context, grid);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint background = new Paint();
        background.setColor(getResources().getColor(R.color.background_material_dark));

        Paint cell = new Paint();
        cell.setColor(getResources().getColor(R.color.background_material_light));

        //draw background
        int width = getWidth();
        canvas.drawRect(0, 0, getWidth(), getHeight(), background);

        //draw cells
        for (int h = 0; h < LifePreview.HEIGHT; h++) {
            for (int w = 0; w < LifePreview.WIDTH; w++) {
                if (LifePreview.getPreviewGrid()[h][w] == 1) {
                    canvas.drawRect(w * LifePreview.CELL_SIZE,
                            h * LifePreview.CELL_SIZE,
                            (w * LifePreview.CELL_SIZE) + LifePreview.CELL_SIZE,
                            (h * LifePreview.CELL_SIZE) + LifePreview.CELL_SIZE,
                            cell);
                }
            }
        }
    }

    private void initGameView() {
        setFocusable(true);
    }
}
