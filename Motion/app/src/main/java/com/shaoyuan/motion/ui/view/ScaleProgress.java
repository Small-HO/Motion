package com.shaoyuan.motion.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by small-ho on 2019/7/21 11:09
 * title：自定义刻度进度条
 */
public class ScaleProgress extends View {

    private Paint mPaint;       //  画笔
    private Thread uiThread;    //  ui线程

    private int mWidth;         //  控件宽
    private int mHeight;        //  控件高

    public ScaleProgress(Context context) {
        super(context);
        initView();
    }

    public ScaleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ScaleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setDither(true);     //  图像抖动    颜色清晰饱满
        mPaint.setAntiAlias(true);  //  开启抗锯齿   损失部分性能
        mPaint.setStrokeCap(Paint.Cap.ROUND);   //  笔帽  圆形
        mPaint.setStrokeJoin(Paint.Join.ROUND); //  两线相交样式  圆角
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = measureHanlder(widthMeasureSpec);
        mHeight = measureHanlder(heightMeasureSpec);
        setMeasuredDimension(mWidth,mHeight);
    }

    private int measureHanlder(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.max(result, specSize);
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int raius = Math.min(mWidth, mHeight) / 2;
        canvas.drawCircle(mWidth / 2,mHeight / 2,raius,mPaint);
    }

    /** 设置进度条 */
    public void setProgress(int count) {
        synchronized (ScaleProgress.class) {
            if (Thread.currentThread() != uiThread) {
                postInvalidate();
            }else {
                invalidate();
            }
        }
    }
}
