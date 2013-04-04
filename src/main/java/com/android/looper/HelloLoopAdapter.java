package com.android.looper;

import static java.lang.Math.random;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

public class HelloLoopAdapter implements LoopAdapter {

    List<DrawableObject> drawableObjects = new ArrayList<DrawableObject>();

    private GithubObject octocat;

    public void init(Context context) {
        octocat = new GithubObject(context);
        drawableObjects.add(octocat);
    }

    @Override
    public void update(long elapsedTime) {
        if (octocat != null) {
            octocat.setY((float) random() * 100f);
        }
    }

    @Override
    public List<DrawableObject> getDrawableObjects() {
        return drawableObjects;
    }

    @Override
    public void drawBackground(Canvas canvas) {
        canvas.drawColor(Color.RED);
    }

}
