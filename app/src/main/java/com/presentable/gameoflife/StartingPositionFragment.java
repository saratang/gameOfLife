package com.presentable.gameoflife;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SaraTang on 2015-12-18.
 */
public class StartingPositionFragment extends Fragment {
    private Context context;
    private Grid grid;

    public static StartingPositionFragment newInstance(int position) {
        StartingPositionFragment startingPositionFragment = new StartingPositionFragment();
        Bundle args = new Bundle();
        args.putSerializable("grid", IOManager.startingPositionsSet.get(position));
        startingPositionFragment.setArguments(args);
        return startingPositionFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity().getApplicationContext();
        this.grid = (Grid) getArguments().getSerializable("grid");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        GamePreview gamePreview = (GamePreview) v.findViewById(R.id.game_preview);
        GamePreviewAdapter gamePreviewAdapter = new GamePreviewAdapter(context, grid);

        gamePreview.setAdapter(gamePreviewAdapter);

        Button beginButton = (Button) v.findViewById(R.id.fragment_main_btn_begin);
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GameActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
