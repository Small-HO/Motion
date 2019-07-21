package com.shaoyuan.motion.utils;

import android.graphics.PointF;

/**
 * Created by small-ho on 2019/7/19 9:50
 * title：
 */
public class ChartUtils {
    /**
     * 依圆心坐标，半径，扇形角度，计算出扇形终射线与圆弧交叉点的xy坐标
     *
     * @param cirX 圆centerX
     * @param cirY 圆centerY
     * @return 扇形终射线与圆弧交叉点的xy坐标
     */
    public static PointF calcArcEndPointXY(float cirX, float cirY, float radius, float
            cirAngle) {
        float posX = 0.0f;
        float posY = 0.0f;
        //将角度转换为弧度
        float arcAngle = (float) (Math.PI * cirAngle / 180.0);
        if (cirAngle < 90) {
            posX = cirX + (float) (Math.cos(arcAngle)) * radius;
            posY = cirY + (float) (Math.sin(arcAngle)) * radius;
        } else if (cirAngle == 90) {
            posX = cirX;
            posY = cirY + radius;
        } else if (cirAngle > 90 && cirAngle < 180) {
            arcAngle = (float) (Math.PI * (180 - cirAngle) / 180.0);
            posX = cirX - (float) (Math.cos(arcAngle)) * radius;
            posY = cirY + (float) (Math.sin(arcAngle)) * radius;
        } else if (cirAngle == 180) {
            posX = cirX - radius;
            posY = cirY;
        } else if (cirAngle > 180 && cirAngle < 270) {
            arcAngle = (float) (Math.PI * (cirAngle - 180) / 180.0);
            posX = cirX - (float) (Math.cos(arcAngle)) * radius;
            posY = cirY - (float) (Math.sin(arcAngle)) * radius;
        } else if (cirAngle == 270) {
            posX = cirX;
            posY = cirY - radius;
        } else {
            arcAngle = (float) (Math.PI * (360 - cirAngle) / 180.0);
            posX = cirX + (float) (Math.cos(arcAngle)) * radius;
            posY = cirY - (float) (Math.sin(arcAngle)) * radius;
        }
        return new PointF(posX, posY);
    }

    /**
     * 依圆心坐标，半径，扇形角度，计算出扇形终射线与圆弧交叉点的xy坐标
     *
     * @param cirX   圆centerX
     * @param cirY   圆centerY
     * @param radius 圆半径
     * @return 扇形终射线与圆弧交叉点的xy坐标
     */
    public static PointF calcArcEndPointXY(float cirX, float cirY, float radius, float
            cirAngle, float orginAngle) {
        cirAngle = (orginAngle + cirAngle) % 360;
        return calcArcEndPointXY(cirX, cirY, radius, cirAngle);
    }

    public static double calSweep(float x, float y, float radius) {
        double sweep = 0;
        if (x > radius) {
            if (y <= radius) {
//                一
                double t = (x - radius) / (radius - y);
                sweep = (Math.toDegrees(Math.atan(t))) + 270;
            } else {
//                四
                double t = (y - radius) / (x - radius);
                sweep = (Math.toDegrees(Math.atan(t)));
            }

        } else {
            if (y <= radius) {
//                二
                double t = (radius - y) / (radius - x);
                sweep = (Math.toDegrees(Math.atan(t))) + 180;
            } else {
//                三
                double t = (radius - x) / (y - radius);
                sweep = (Math.toDegrees(Math.atan(t))) + 90;
            }

        }

        return sweep % 360;
    }

    public static PointF calPointByAngle(int x, int y, int r, float angle) {
        PointF p = new PointF();

        if (angle >= 0 && angle < 90) {
//            第四象限
            p.x = (float) (r * (Math.cos(Math.PI * angle / 180.0)) + 1);
            p.y = (float) (r * (1 + Math.sin(Math.PI * angle / 180.0)));

        } else if (angle >= 90 && angle < 180) {
//            第三象限
            p.x = (float) (r * (-Math.sin(Math.PI * (angle - 90) / 180.0)) + 1);
            p.y = (float) (r * (1 + Math.cos(Math.PI * (angle - 90) / 180.0)));
        } else if (angle >= 180 && angle < 270) {
//            第二象限
            p.x = (float) (r * (-Math.cos(Math.PI * (angle - 180) / 180.0)) + 1);
            p.y = (float) (r * (1 - Math.sin(Math.PI * (angle - 180) / 180.0)));
        } else if (angle >= 270 && angle <= 360) {
//            第一象限
            p.x = (float) (r * (Math.sin(Math.PI * (angle - 270) / 180.0)) + 1);
            p.y = (float) (r * (1 - Math.cos(Math.PI * (angle - 270) / 180.0)));
        }

        return p;
    }
}
