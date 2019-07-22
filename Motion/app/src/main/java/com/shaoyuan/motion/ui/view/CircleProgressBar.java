package com.shaoyuan.motion.ui.view;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.shaoyuan.motion.R;


/**
 * Created by zhb on 2017/2/26.
 */
public class CircleProgressBar extends View {
    private Object lock = new Object();
    /**
     * 默认刻度间隔角度
     */
    private final int TICK_SPLIT_DEFAULT_ANGLE = 2;
    /**
     * 默认刻度角度
     */
    private final int TICK_BLOCK_DEFAULT_ANGLE = 2;
    /**
     * 默认刻度长度
     */
    private final float NORMAL_TICK_DEFAULT_SIZE = 80;
    /**
     * 默认当前刻度长度
     */
    private final float CURRENT_TICK_DEFAULT_SIZE = 160;
    /**
     * 默认渐变起始颜色
     */
    private final int GRADIENT_START_DEFAULT_COLOR = Color.parseColor("#474FFF");
    /**
     * 默认渐变结束颜色
     */
    private final int GRADIENT_END_DEFAULT_COLOR = Color.RED;
    private final int TICK_NORMAL_DEFAULT_COLOR = Color.GRAY;

    private Paint mPaint;
    /**
     * 刻度数量
     */
    private int mTotalTickCount;
    /**
     * 刻度间隔
     */
    private float mTickSplitAngle;
    /**
     * 正常刻度的长度
     */
    private float mNormalTickSize;
    /**
     * 当前刻度的长度
     */
    private float mCurrentTickSize;
    /**
     * 渐变起始颜色
     */
    private int mGradientStartColor;
    /**
     * 渐变结束颜色
     */
    private int mGradientEndColor;
    /**
     * 刻度未选中颜色
     */
    private int mTickNormalColor;
    /**
     * 当前进度
     */
    private int mCurrentProgressPercent;
    /**
     * 直径
     */
    private int mCircleWidth;
    /**
     * 刻度角度
     */
    private float mBlockAngle;

    private RectF mRect;
    private RectF mRect1;
    private RectF mRect2;

    private ArgbEvaluator mArgbEvaluator;

    private Thread uiThread;

    public CircleProgressBar(Context context) {
        this(context, null, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyleAttr, 0);
        init(typedArray);
    }

    private void init(TypedArray typedArray) {
        mTickSplitAngle = typedArray.getDimension(R.styleable.CustomProgressBar_tick_split_angle, TICK_SPLIT_DEFAULT_ANGLE);
        mNormalTickSize = typedArray.getDimension(R.styleable.CustomProgressBar_normal_tick_size, NORMAL_TICK_DEFAULT_SIZE);
        mCurrentTickSize = typedArray.getDimension(R.styleable.CustomProgressBar_current_tick_size, CURRENT_TICK_DEFAULT_SIZE);
        mBlockAngle = typedArray.getDimension(R.styleable.CustomProgressBar_tick_block_angle, TICK_BLOCK_DEFAULT_ANGLE);
        mGradientStartColor = typedArray.getColor(R.styleable.CustomProgressBar_gradient_start_color, GRADIENT_START_DEFAULT_COLOR);
        mGradientEndColor = typedArray.getColor(R.styleable.CustomProgressBar_gradient_start_color, GRADIENT_END_DEFAULT_COLOR);
        mTickNormalColor = typedArray.getColor(R.styleable.CustomProgressBar_tick_normal_color, TICK_NORMAL_DEFAULT_COLOR);
        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mTotalTickCount = (int) (450f / (mTickSplitAngle + mBlockAngle));//确保刻度数量为整数
        uiThread = Thread.currentThread();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureHanlder(widthMeasureSpec);
        int height = measureHanlder(heightMeasureSpec);
        mCircleWidth = (width < height) ? width : height;
        mCircleWidth = mCircleWidth + 300;
        setMeasuredDimension(mCircleWidth, mCircleWidth);
        mRect = new RectF(mCurrentTickSize * 2, mCurrentTickSize * 2, mCircleWidth - mCurrentTickSize * 2, mCircleWidth - mCurrentTickSize * 2);
        int b = 26;
        mRect1 = new RectF(mCurrentTickSize * b / 10, mCurrentTickSize * b / 10, mCircleWidth - mCurrentTickSize * b / 10, mCircleWidth - mCurrentTickSize * b / 10);
        b = 24;
        mRect2 = new RectF(mCurrentTickSize * b / 10, mCurrentTickSize * b / 10, mCircleWidth - mCurrentTickSize * b / 10, mCircleWidth - mCurrentTickSize * b / 10);
        mArgbEvaluator = new ArgbEvaluator();
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
        final int currentBlockIndex = (int) (mCurrentProgressPercent / 100f * mTotalTickCount);
        for (int i = 33; i < (mTotalTickCount - 10); i++) {
            if (i == currentBlockIndex - 0) {
                //当前刻度，刻度长度较长
                mPaint.setStrokeWidth(mCurrentTickSize);
                mPaint.setColor((Integer) mArgbEvaluator.evaluate(i * (mBlockAngle + mTickSplitAngle) / (450), mGradientStartColor, mGradientEndColor));
            } else if (i < currentBlockIndex) {
                //已选中的刻度
                mPaint.setStrokeWidth(mNormalTickSize);
                mPaint.setColor((Integer) mArgbEvaluator.evaluate(i * (mBlockAngle + mTickSplitAngle) / (450), mGradientStartColor, mGradientEndColor));
            } else {
                //未选中的刻度
                mPaint.setStrokeWidth(mNormalTickSize);
                mPaint.setColor(mTickNormalColor);
            }
            canvas.drawArc(mRect, i * (mBlockAngle + mTickSplitAngle), mBlockAngle, false, mPaint);
        }

        for (int i = 33; i < (mTotalTickCount - 10); i++) {
//            if (i == currentBlockIndex - 0) {
//                //当前刻度，刻度长度较长
//                mPaint.setStrokeWidth(40);
//                mPaint.setColor((Integer) mArgbEvaluator.evaluate(i * (mBlockAngle + mTickSplitAngle) / (450), mGradientStartColor, mGradientEndColor));
//            } else if (i < currentBlockIndex) {
//                //已选中的刻度
//                mPaint.setStrokeWidth(20);
//                if (i == 45 || i == 60 || i == 75 || i == 90) {
//                    mPaint.setStrokeWidth(30);
//                }
//                mPaint.setColor((Integer) mArgbEvaluator.evaluate(i * (mBlockAngle + mTickSplitAngle) / (450), mGradientStartColor, mGradientEndColor));
//            } else
            if (i == 30 || i == 45 || i == 60 || i == 75 || i == 90 || i == 105) {
                //已选中的刻度
                mPaint.setStrokeWidth(35);
                mPaint.setColor(mTickNormalColor);
            } else {
                //未选中的刻度
                mPaint.setStrokeWidth(25);
                mPaint.setColor(mTickNormalColor);
            }
            canvas.drawArc(mRect1, i * (mBlockAngle + mTickSplitAngle), mBlockAngle, false, mPaint);
        }

        for (int i = 33; i < (mTotalTickCount - 10); i++) {
            mPaint.setStrokeWidth(45);
            mPaint.setColor(Color.parseColor("#ffffff"));
            canvas.drawArc(mRect2, i * (mBlockAngle + mTickSplitAngle), mBlockAngle + 3, false, mPaint);
        }


    }

    /**
     * 设置进度
     *
     * @param percent 百分百
     */
    public void setProgress(int percent) {
        mCurrentProgressPercent = percent;
        synchronized (lock) {
            if (Thread.currentThread() != uiThread) {
                postInvalidate();
            } else {
                invalidate();
            }
        }

    }
}
