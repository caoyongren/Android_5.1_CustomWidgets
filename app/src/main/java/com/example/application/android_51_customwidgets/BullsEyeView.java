package com.example.application.android_51_customwidgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by matthew on 17-6-4.
 */

public class BullsEyeView extends View{

    private Paint mPaint;
    private Point mCenter;
    private float mRadius;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width, height;
        int contentWidth = 200;
        int contentHeight = 200;

        width = getMeasurement(widthMeasureSpec, contentWidth);
        height = getMeasurement(heightMeasureSpec, contentHeight);
        //必须使用测量值调用该方法；
        setMeasuredDimension(width, height);
    }

    /* Constructor*/
    public BullsEyeView(Context context) {
        this(context, null);
    }

    public BullsEyeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BullsEyeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mCenter = new Point();
    }

    /*
     * 用于测量的宽度和高度的辅助方法；
     * */
    private int getMeasurement(int measureSpec, int contentSize) {
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (MeasureSpec.getMode(measureSpec)) {
            case MeasureSpec.AT_MOST:
                return Math.min(specSize, contentSize);
            case MeasureSpec.EXACTLY:
                return specSize;
            case MeasureSpec.UNSPECIFIED:
                return contentSize;
            default:
                return 0;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w != oldw || h != oldh) {
            mCenter.x = w / 2;
            mCenter.y = h / 2;
            mRadius = Math.min(mCenter.x, mCenter.y);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.8f, mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.6F, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.4F, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.2F, mPaint);
    }
}
