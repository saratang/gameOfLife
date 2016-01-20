package com.presentable.gameoflife;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.os.Handler;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class GameView extends View {
    static final int RUNNING = 1;
    static final int PAUSE = 0;

    private Life _life;
    private int mode;

    private static final long DELAY = 250;
    private RedrawHandler _redrawHandler = new RedrawHandler();

    class RedrawHandler extends Handler {

        @Override
        public void handleMessage(Message message) {
            GameView.this.update();
            GameView.this.invalidate();
        }

        public void sleep(long delay) {
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delay);
        }

        public void pause() {
            this.removeMessages(0);
        }
    }

    private static final int CELL_SIZE = 4;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        _life = new Life(context);
        initGameView();
    }

    public void setMode(int mode) {
        this.mode = mode;
        if (mode == RUNNING) {
            update();
            return;
        }
        if (mode == PAUSE) {
            pause();
            return;
        }
    }

    public int getMode() {
        return mode;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint background = new Paint();
        background.setColor(getResources().getColor(R.color.background_material_dark));

        Paint cell = new Paint();
        cell.setColor(getResources().getColor(R.color.background_material_light));

        //draw background
        canvas.drawRect(0, 0, getWidth(), getHeight(), background);

        //draw cells
        for (int h = 0; h < Life.HEIGHT; h++) {
            for (int w = 0; w < Life.WIDTH; w++) {
                if (Life.getGameGrid()[h][w] == 1) {
                    canvas.drawRect(w * Life.CELL_SIZE,
                            h * Life.CELL_SIZE,
                            (w * Life.CELL_SIZE) + Life.CELL_SIZE,
                            (h * Life.CELL_SIZE) + Life.CELL_SIZE,
                            cell);
                }
            }
        }
    }

    public void update() {
        _life.generateNext();
        _redrawHandler.sleep(DELAY);
    }

    public void pause() {
        _redrawHandler.pause();
    }

    private void initGameView() {
        setFocusable(true);
    }
}
