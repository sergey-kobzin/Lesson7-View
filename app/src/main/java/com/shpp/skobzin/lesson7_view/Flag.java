package com.shpp.skobzin.lesson7_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class Flag extends View {

    private final String TAG = "Flag";
    private Random mRandom = new Random(System.currentTimeMillis());
    Paint mTopLinePaint = new Paint();
    Paint mBottomLinePaint = new Paint();

    public Flag(Context context) {
        this(context, null);
    }

    public Flag(Context context, AttributeSet attrs) {
        super(context, attrs);

        mTopLinePaint.setARGB(255, mRandom.nextInt(), mRandom.nextInt(), mRandom.nextInt());
        mBottomLinePaint.setARGB(255, mRandom.nextInt(), mRandom.nextInt(), mRandom.nextInt());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i(TAG, "onDraw");
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        Log.i(TAG, String.valueOf(width));
        Log.i(TAG, String.valueOf(height));

        canvas.drawRect(0, 0, width, height / 2, mTopLinePaint);
        canvas.drawRect(0, height / 2, width, height, mBottomLinePaint);
    }

    protected void reDraw() {
        mTopLinePaint.setARGB(255, mRandom.nextInt(), mRandom.nextInt(), mRandom.nextInt());
        mBottomLinePaint.setARGB(255, mRandom.nextInt(), mRandom.nextInt(), mRandom.nextInt());
        invalidate();
    }
}
