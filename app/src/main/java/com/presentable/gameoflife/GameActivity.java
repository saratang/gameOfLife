package com.presentable.gameoflife;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends Activity {
    private GameView _gameView;
    private FrameLayout _deviceScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final Resources res = getResources();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toast.makeText(this, "Tap to pause/enable settings!", Toast.LENGTH_SHORT).show();

        _gameView = (GameView) findViewById(R.id.game_view);
        _gameView.setMode(GameView.RUNNING);

        _deviceScreen = (FrameLayout) findViewById(R.id.device_screen);

        _deviceScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (_gameView.getMode() == GameView.RUNNING) {
                    _gameView.setMode(GameView.PAUSE);
                } else { //_gameView.getMode() == GameView.PAUSE
                    _gameView.setMode(GameView.RUNNING);
                }
            }
        });
    }
}
