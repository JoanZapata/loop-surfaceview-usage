package com.android.looper;

import android.app.Activity;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class HelloActivity extends Activity {

    @ViewById(R.id.sample)
    protected LoopSurfaceView loopSurfaceView;

    private HelloLoopAdapter adapter;

    @AfterViews
    protected void init() {
        // Bind adapter
        adapter = new HelloLoopAdapter();
        loopSurfaceView.setAdapter(adapter);
        initBackground();
    }

    @Background
    protected void initBackground() {
        // Init adapter (in background because of image loading)
        adapter.init(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loopSurfaceView.play();
    }

    @Override
    protected void onPause() {
        super.onPause();
        loopSurfaceView.pause();
    }

}
