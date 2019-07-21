package com.shaoyuan.motion.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.shaoyuan.motion.R;

import static com.shaoyuan.motion.ui.view.CircleDoubleSliding.imageScale;

/**
 * Created by small-ho on 2019/7/19 8:40
 * title：消耗摄入进度条
 */
public class EnergyProgressBar extends View {

    private int mWidth = 0;
    private int mHeight = 0;
    private int mProgress = 50;
    private int mInclination = 40;
    private float mPerc = 0;

    private Paint mPaint;

    private int Margin = 17;

    public EnergyProgressBar(Context context) {
        super(context);
    }

    public EnergyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EnergyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
        mPerc = mWidth / 92;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initPaint();
        drawMiddle(canvas);
        drawLeftBar(canvas);
        drawLeftGtadual(canvas);

        drawRightBar(canvas);
        drawRightGradual(canvas);

        drawX(canvas);
        drawN(canvas);
        drawLeftText(canvas);
        drawRightText(canvas);
    }

    private void initPaint() {
        mPaint = new Paint();
        //  抗锯齿
        mPaint.setAntiAlias(true);
        //  使用图像抖动处理
        mPaint.setDither(true);
        //  空心
        mPaint.setStyle(Paint.Style.FILL);
        //  文字居中
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    private void drawMiddle(Canvas canvas) {
        LinearGradient lg = new LinearGradient(
                0,0,mWidth,mHeight,
                Color.parseColor("#00000000"),Color.parseColor("#00000000"),
                Shader.TileMode.REPEAT
        );
        mPaint.setShader(lg);

        Path path = new Path();
        path.moveTo(mProgress * mPerc,0);   //  多边形起点
        path.lineTo((mProgress + 1) * mPerc,0);
        path.lineTo((mProgress + 1) * mPerc - mInclination,mHeight);
        path.lineTo(mProgress * mPerc - mInclination,mHeight);
        path.close();       //  封闭多边形
        canvas.drawPath(path,mPaint);
    }

    private void drawLeftBar(Canvas canvas) {
        LinearGradient lg = new LinearGradient(
                mHeight / 2,mHeight,mProgress * mPerc,mHeight,
                Color.parseColor("#5FFCC9"),Color.parseColor("#0BDBE3"),
                Shader.TileMode.REPEAT
        );
        mPaint.setShader(lg);
        Path path = new Path();
        path.moveTo(mHeight / 2,0); //  此点为多边形的起点
        path.lineTo(mProgress * mPerc,0);
        path.lineTo(mProgress * mPerc - mInclination,mHeight);
        path.lineTo(mHeight / 2,mHeight);
        path.close();   //  封闭多边形
        canvas.drawPath(path,mPaint);
    }

    private void drawLeftGtadual(Canvas canvas) {
        LinearGradient lg = new LinearGradient(
                mHeight / 2,mHeight,mProgress * mPerc,mHeight,
                Color.parseColor("#00E2B0"),Color.parseColor("#02DADC"),
                Shader.TileMode.REPEAT
        );
        mPaint.setShader(lg);
        Path path = new Path();
        path.moveTo(mHeight / 2,mHeight / 2);   //  多边形起点
        path.lineTo(mProgress * mPerc - mInclination / 2,mHeight / 2);
        path.lineTo(mProgress * mPerc - mInclination,mHeight);
        path.lineTo(mHeight / 2,mHeight);
        path.close();   //  封闭多边形
        canvas.drawPath(path,mPaint);
    }

    private void drawRightBar(Canvas canvas) {
        LinearGradient lg = new LinearGradient((mProgress + 1) * mPerc - mInclination,mHeight,mWidth - mHeight / 2,mHeight,
                Color.parseColor("#FC6553"),Color.parseColor("#FB4B74"),
                Shader.TileMode.REPEAT
        );
        mPaint.setShader(lg);

        Path path = new Path();
        path.moveTo((mProgress + 1) * mPerc,0); //  多边形起点
        path.lineTo(mWidth - mHeight / 2,0);
        path.lineTo(mWidth - mHeight / 2,mHeight);
        path.lineTo((mProgress + 1) * mPerc - mInclination,mHeight);
        path.close();   //  封闭多边形
        canvas.drawPath(path,mPaint);
    }

    private void drawRightGradual(Canvas canvas) {
        LinearGradient lg = new LinearGradient((mProgress + 1) * mPerc - mInclination, mHeight, mWidth - mHeight / 2, mHeight,
                Color.parseColor("#FB5A47"), Color.parseColor("#F7476F"),
                Shader.TileMode.REPEAT);
        mPaint.setShader(lg);

        Path path = new Path();
        path.moveTo((mProgress + 1) * mPerc, mHeight / 2);// 此点为多边形的起点
        path.lineTo(mWidth - mHeight / 2, mHeight / 2);
        path.lineTo(mWidth - mHeight / 2, mHeight);
        path.lineTo((mProgress + 1) * mPerc - mInclination, mHeight);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, mPaint);
    }


    private void drawX(Canvas canvas) {
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.xiaohao1)).getBitmap();
        bitmap = imageScale(bitmap, mHeight, mHeight);
        canvas.drawBitmap(bitmap, 0, 0, mPaint);
    }

    private void drawN(Canvas canvas) {
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.sheru1)).getBitmap();
        bitmap = imageScale(bitmap, mHeight, mHeight);
        canvas.drawBitmap(bitmap, mWidth - mHeight, 0, mPaint);
    }

    private void drawLeftText(Canvas canvas) {
        LinearGradient lg = new LinearGradient(0, 0, mWidth, mHeight,
                Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"),
                Shader.TileMode.REPEAT);
        mPaint.setShader(lg);
        String text = "消耗";
        mPaint.setFakeBoldText(true);
        mPaint.setTextSize(50);
        canvas.drawText(text, mHeight * (40 - Margin) / 10, mHeight * 6 / 10, mPaint);
    }

    private void drawRightText(Canvas canvas) {
        String text = "摄入";
        mPaint.setFakeBoldText(true);
        mPaint.setTextSize(50);
        canvas.drawText(text, mWidth - mHeight * Margin / 10, mHeight * 6 / 10, mPaint);
    }

    public void setData(int mProgress) {
        this.mProgress = mProgress;
        if (mProgress <= 10) {
            Margin = 35;
        } else if (mProgress > 10 && mProgress <= 20) {
            Margin = 34;
        } else if (mProgress > 20 && mProgress <= 30) {
            Margin = 31;
        } else if (mProgress > 30 && mProgress <= 40) {
            Margin = 25;
        } else if (mProgress > 40 && mProgress <= 60) {
            Margin = 20;
        } else if (mProgress > 60 && mProgress <= 70) {
            Margin = 15;
        } else if (mProgress > 70 && mProgress <= 80) {
            Margin = 9;
        } else if (mProgress > 80 && mProgress <= 90) {
            Margin = 6;
        } else {
            Margin = 5;
        }
        invalidate();
    }
}
