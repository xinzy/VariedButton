package com.xinzy.variedbutton.widget.builder;

import android.graphics.drawable.GradientDrawable;

/**
 * Created by Xinzy on 2017-01-04.
 *
 */
public class GradientDrawableBuilder {

    private float radiusLT; //左上角圆角
    private float radiusRT; //右上角圆角
    private float radiusLB; //左下角圆角
    private float radiusRB; //右下角圆角

    private int strokeWidth;  //描边宽度
    private int strokeColor;    //描边颜色
    private int solidColor;     //填充色

    public GradientDrawableBuilder setRadius(float radius) {
        radiusLT = radiusRT = radiusLB = radiusRB = radius;
        return this;
    }

    public GradientDrawableBuilder setRadius(float lt, float rt, float lb, float rb) {
        radiusLT = lt;
        radiusRT = rt;
        radiusLB = lb;
        radiusRB = rb;
        return this;
    }

    public GradientDrawableBuilder setStroke(int width, int color) {
        strokeWidth = width;
        strokeColor = color;
        return this;
    }

    public GradientDrawableBuilder setSolid(int color) {
        solidColor = color;
        return this;
    }

    public GradientDrawable create() {
        GradientDrawable drawable = new GradientDrawable();

        float[] radii = {
                radiusLT, radiusLT,
                radiusRT, radiusRT,
                radiusLB, radiusLB,
                radiusRB, radiusRB,
        };
        drawable.setCornerRadii(radii);

        if (strokeWidth > 0) {
            drawable.setStroke(strokeWidth, strokeColor);
        }
        drawable.setColor(solidColor);

        return drawable;
    }
}
