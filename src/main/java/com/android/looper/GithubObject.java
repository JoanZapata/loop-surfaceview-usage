package com.android.looper;

import static com.android.looper.util.DrawableUtil.loadBitmap;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class GithubObject implements DrawableObject {

    private float x, y;

    private int width, height;

    private Bitmap image;

    private Paint paint = new Paint();

    public GithubObject(Context context) {
        Log.i("Joan", "Initialized octocat");
        image = loadBitmap(context, R.drawable.octocat);
        width = image.getWidth();
        height = image.getHeight();
    }

    @Override
    public Rect[] draw(Canvas canvas) {
        Log.i("Joan", "Draw octocat");

        // Centers image
        x = canvas.getWidth() / 2f - width / 2f;

        // Draws bitmap
        canvas.drawBitmap(image, x, y, paint);

        // Returns the bounds of the drawing
        return new Rect[] { new Rect( //
                (int) x, (int) y, //
                (int) x + width, (int) y + height) };
    }

    public void setY(float y) {
        Log.i("Joan", "Set octocat " + y);
        this.y = y;
    }

}
