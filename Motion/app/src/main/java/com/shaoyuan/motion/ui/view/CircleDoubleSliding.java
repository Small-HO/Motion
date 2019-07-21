package com.shaoyuan.motion.ui.view;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.shaoyuan.motion.R;
import com.shaoyuan.motion.utils.ChartUtils;

/**
 * Created by small-ho on 2019/7/19 9:48
 * title：
 */
public class CircleDoubleSliding extends View {
    private Paint mPaint;
    private int circleColor;//没有选择的部分颜色
    private int progressColor;//已经选择的部分圆的颜色
    private int progressEndColor;//已经选择的部分圆的颜色
    private int progressWidth;//外侧圆的半径
    private float startAngle;
    private float sweepAngle;
    private int radius;
    private int centreX;
    private int centreY;
    private int maxError = 70;
    private int maxError0 = 70;
    private boolean downOnArc;
    private boolean isSecond = true;
    private int maxProgress = 100;
    /**
     * 中间进度百分比的字符串的颜色
     */
    private int textColor;

    /**
     * 中间进度百分比的字符串的字体
     */
    private float textSize;
    private ArgbEvaluator mArgbEvaluator;

    public CircleDoubleSliding(Context context) {
        this(context, null);
    }

    public CircleDoubleSliding(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleDoubleSliding(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();

        circleColor = Color.parseColor("#F5F5F5");
        progressColor = Color.parseColor("#11D59B");
        progressEndColor = Color.parseColor("#8B98FE");
        progressWidth = 120;
        startAngle = 210;
        sweepAngle = 240;
        textColor = Color.BLACK;
        textSize = 40;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取测量模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //获取测量大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int mWidth = 0;
        int mHeight = 0;

        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            radius = widthSize / 2;
            centreX = widthSize / 2;
            centreY = heightSize / 2;

            mWidth = widthSize;
            mHeight = heightSize;
        }

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            mWidth = (int) (radius * 2);
            mHeight = (int) (radius * 2);
            centreX = radius;
            centreY = radius;

        }
        setMeasuredDimension(mWidth, mHeight);
    }

    private Paint mPaint1;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint1 = new Paint();
        mArgbEvaluator = new ArgbEvaluator();
        mPaint.setColor(circleColor);
        mPaint.setStrokeWidth(progressWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
//        RectF rect = new RectF(progressWidth, progressWidth, getWidth() - progressWidth, getHeight() - progressWidth);
        RectF rect = new RectF(progressWidth * 2, progressWidth * 2, getWidth() - progressWidth * 2, getHeight() - progressWidth * 2);
        canvas.drawArc(rect, 0, 360, false, mPaint);
        // 创建SweepGradient对象
        mPaint1.setStrokeWidth(progressWidth);
        mPaint1.setAntiAlias(true);
        mPaint1.setStyle(Paint.Style.STROKE);
        SweepGradient sweepGradient = new SweepGradient(1200, 200, progressColor, progressEndColor);
        mPaint1.setShader(sweepGradient);
        canvas.drawArc(rect, startAngle, sweepAngle, false, mPaint1);

//        画小圆
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(4);
        p.setStyle(Paint.Style.FILL);
//        Shader shader1 = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
//        p.setShader(shader1);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ty);
        bitmap = imageScale(bitmap, progressWidth, progressWidth);
        PointF point = ChartUtils.calcArcEndPointXY(centreX, centreY, radius - progressWidth * 2, sweepAngle, startAngle);
        canvas.drawBitmap(bitmap, point.x - progressWidth / 2, point.y - progressWidth / 2, p);
//        canvas.drawRect(point.x, point.y, bitmap.getWidth() + point.x, bitmap.getHeight() + point.y, p);
//        canvas.drawCircle(point.x, point.y, 40, p);
        //        画小圆2
        Paint p1 = new Paint();
        p1.setColor(Color.RED);
        p1.setStrokeWidth(4);
        p1.setStyle(Paint.Style.FILL);
        p1.setColor(Color.YELLOW);
        PointF point2 = ChartUtils.calcArcEndPointXY(centreX, centreY, radius - progressWidth * 2, 0, startAngle);
//        canvas.drawCircle(point2.x, point2.y, 40, p1);
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.yl);
        bitmap1 = imageScale(bitmap1, progressWidth, progressWidth);
//        PointF point1 = ChartUtils.calcArcEndPointXY(centreX, centreY, radius - progressWidth * 2, sweepAngle, startAngle);
        canvas.drawBitmap(bitmap1, point2.x - progressWidth / 2, point2.y - progressWidth / 2, p1);

        /**
         * 画文字
         */
//        mPaint.setStrokeWidth(0);
//        mPaint.setColor(textColor);
//        mPaint.setTextSize(textSize);
//        String textTime = getTimeText(startAngle, sweepAngle);
//        float textWidth = mPaint.measureText(textTime);
//        canvas.drawText(textTime, centreX - textWidth / 2, centreY + textSize / 2, mPaint);
    }

    private String getTimeText(float startAngle, float sweepAngle) {
        float startProgress = (startAngle + 90) % 360 / 360 * maxProgress;
        float endProgress = sweepAngle / 360 * maxProgress + startProgress;
        String result = Math.round(startProgress) + "<--->" + Math.round(endProgress % maxProgress);
        return result;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:

                if (isTouchArc(x, y)) {

                    downOnArc = true;
                    changePosition(x, y, radius);
                    return true;
                }
                break;
            case MotionEvent.ACTION_MOVE:

                if (downOnArc) {

                    changePosition(x, y, radius);
                    return true;
                }

                break;
            case MotionEvent.ACTION_UP:

                downOnArc = false;

                changePosition(x, y, radius);

                break;
        }
        return super.onTouchEvent(event);
    }

    // 判断是否按在圆边上
    private boolean isTouchArc(int x, int y) {
//        double d = getTouchRadius(x, y);

        PointF p = ChartUtils.calcArcEndPointXY(centreX, centreY, radius * 2 / 3, sweepAngle, startAngle);
        PointF p2 = ChartUtils.calcArcEndPointXY(centreX, centreY, radius * 2 / 3, 0, startAngle);
        int absx = (int) Math.abs(x - p.x);
        int absy = (int) Math.abs(y - p.y);
        int absx2 = (int) Math.abs(x - p2.x);
        int absy2 = (int) Math.abs(y - p2.y);
        if (absx <= maxError && absy <= maxError) {
            isSecond = true;
            return true;
        }
        if (absx2 <= maxError0 && absy2 <= maxError0) {
            isSecond = false;
            return true;
        }

        return false;
    }


    private void changePosition(int x, int y, int r) {

        double v = ChartUtils.calSweep(x, y, r);
        if (sweepAngle >= 360) {
            sweepAngle = sweepAngle % 360;
        }

        if (isSecond) {
            changeSecond(x, y, r, v);
        } else {
            changeFirst(v);
        }

        if (changeListener != null) {
            changeListener.onProgressChange(startAngle, sweepAngle);
        }
        invalidate();


    }

    //    改变第二个点的位置
    private void changeSecond(int x, int y, int r, double v) {

        if (x > r) {
            if (y <= r) {
                if (v >= startAngle) {
                    sweepAngle = (float) (v - startAngle);
                } else {
                    sweepAngle = (float) (360 - (startAngle - v));
                }
            } else {
                sweepAngle = (float) (360 - (startAngle - v));
            }
        } else {
            sweepAngle = (float) (360 + v - startAngle);
        }
        sweepAngle = sweepAngle % 360;

    }

    //    改变第一个点的位置
    private void changeFirst(double v) {

//        float secondAngle = (startAngle + sweepAngle) % 360;

        if (sweepAngle < 0) {
            sweepAngle = sweepAngle + 360;
        }
        float cSweep = (float) (v - startAngle);
        startAngle = (float) v;
        sweepAngle = sweepAngle - cSweep;

    }

    //    判断第一个原点是不是跟在第二个后面
    private boolean isAfterFllow(float start, float sweep) {

        float startProgress = (startAngle + 90) % 360 / 360 * maxProgress;
        float endProgress = sweepAngle / 360 * maxProgress + startProgress;

        return endProgress <= maxProgress && (Math.ceil(sweep) >= 30);
    }


    // 计算某点到圆点的距离

    private double getTouchRadius(int x, int y) {
        int cx = x - getWidth() / 2;
        int cy = y - getHeight() / 2;
        return Math.hypot(cx, cy);
    }


    private OnProgressChangeListener changeListener;

    public interface OnProgressChangeListener {

        void onProgressChange(float start, float sweep);

    }

    public void setListener(OnProgressChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public static Bitmap imageScale(Bitmap bitmap, int dst_w, int dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,
                true);
        return dstbmp;
    }
}
