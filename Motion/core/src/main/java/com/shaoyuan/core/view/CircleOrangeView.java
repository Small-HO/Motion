package com.shaoyuan.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by small-ho on 2019/7/12 10:41
 * title：
 */
public class CircleOrangeView extends View {

    private int mWidth  = 0;
    private int mHeight = 0;
    private RectF mRectF;
    private int progress = 30;

    public CircleOrangeView(Context context) {
        super(context);
    }

    public CircleOrangeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleOrangeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        initBottomRectF();
        drawBottomCircle(canvas);   //  灰色线
        drawUpCircle(canvas);       //  填充线
        drawWithinRectF(canvas);    //  内环线
        drawSpotRectF(canvas);      //  跟随点
    }

    private Paint mPaint;

    private void initPaint() {
        // 画笔
        mPaint = new Paint();
        // 抗锯齿
        mPaint.setColor(Color.parseColor("#F4F4F4"));
        mPaint.setAntiAlias(true);
        // 设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        mPaint.setDither(true);
        mPaint.setStrokeWidth(28);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        // 空心
        mPaint.setStyle(Paint.Style.STROKE);
        // 文字居中
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    private void initBottomRectF() {
        mRectF = new RectF();
        float x = (mWidth - mHeight / 2) / 2;
        float y = mHeight / 4;
        mRectF = new RectF(x, y, mWidth - x, mHeight - y);
    }

    private void drawBottomCircle(Canvas canvas) {
        canvas.drawArc(mRectF, 135, 270, false, mPaint);
    }

    private void drawUpCircle(Canvas canvas) {
        mPaint.setColor(Color.parseColor("#21C7BF"));
        canvas.drawArc(mRectF, 135, progress * 27 / 10, false, mPaint);
    }

    private void drawWithinRectF(Canvas canvas) {
        mPaint.setStrokeWidth(5);
        mRectF = new RectF();
        float x = (mWidth - mHeight / 2) / 2;
        float y = mHeight / 4;
        int mPadding = 30;
        mRectF = new RectF(x + mPadding, y + mPadding, mWidth - x - mPadding, mHeight - y - mPadding);
        canvas.drawArc(mRectF, 135, 270, false, mPaint);
    }

    private void drawSpotRectF(Canvas canvas) {
        mPaint.setStrokeWidth(50);
        mRectF = new RectF();
        float x = (mWidth - mHeight / 2) / 2;
        float y = mHeight / 4;
        mRectF = new RectF(x, y, mWidth - x, mHeight - y);
        canvas.drawArc(mRectF, (progress) * 27 / 10 + 134, 1, false, mPaint);
    }

    public void setData(int progress) {
        if (progress > 0 && progress <= 100) {
            this.progress = progress;
        } else {
            this.progress = 100;
        }
    }
}
