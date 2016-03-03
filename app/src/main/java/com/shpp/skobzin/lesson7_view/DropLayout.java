package com.shpp.skobzin.lesson7_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

public class DropLayout extends RelativeLayout {

    private final int ANIMATION_DURATION = 2000;
    private final String TAG = "DropLayout";

    private boolean mOriginalPosition = true;

    public DropLayout(Context context) {
        this(context, null);

        this.setOnClickListener(onClickListener);
        this.setOnLongClickListener(onLongClickListener);
    }

    public DropLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        super.setOnClickListener(onClickListener);
        super.setOnLongClickListener(onLongClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i(TAG, "onClick");
            if (mOriginalPosition) {
                runAnimation(mOriginalPosition);
            }
        }
    };

    private OnLongClickListener onLongClickListener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            Log.i(TAG, "onLongClick");
            if (!mOriginalPosition) {
                runAnimation(mOriginalPosition);
            }
            return true;
        }
    };

    private void runAnimation(boolean originalPosition) {
        for (int i = 0; i < getChildCount(); ++i) {
            View child = getChildAt(i);
            TranslateAnimation translateAnimation = null;
            if (mOriginalPosition) {
                translateAnimation = new TranslateAnimation(0, 0, 0, this.getHeight()- child.getY() - child.getHeight() - this.getPaddingTop() - this.getPaddingBottom());
            } else {
                translateAnimation = new TranslateAnimation(0, 0, this.getHeight() - child.getY() - child.getHeight() - this.getPaddingTop() - this.getPaddingBottom(), 0);
            }
            translateAnimation.setDuration(ANIMATION_DURATION);
            translateAnimation.setAnimationListener(animationListener);
            translateAnimation.setFillAfter(true);
            child.startAnimation(translateAnimation);
        }
        mOriginalPosition = !mOriginalPosition;
    }

    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            DropLayout.this.setOnClickListener(null);
            DropLayout.this.setOnLongClickListener(null);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            DropLayout.this.setOnClickListener(onClickListener);
            DropLayout.this.setOnLongClickListener(onLongClickListener);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };
}
