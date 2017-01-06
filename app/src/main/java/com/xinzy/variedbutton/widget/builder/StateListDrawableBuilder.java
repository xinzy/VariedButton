package com.xinzy.variedbutton.widget.builder;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.ArrayMap;

import java.util.Map;

/**
 * Created by Xinzy on 2017-01-04.
 *
 */
public class StateListDrawableBuilder {

    private Drawable defaultDrawable = new ColorDrawable(0x00000000);
    private Map<Integer, Drawable> drawableStates;

    public StateListDrawable create() {
        StateListDrawable drawable = new StateListDrawable();
        if (drawableStates != null && drawableStates.size() > 0) {
            for (Integer key : drawableStates.keySet()) {
                drawable.addState(new int[] {key}, drawableStates.get(key));
            }
        }
        drawable.addState(new int[] {}, defaultDrawable);
        return drawable;
    }

    public StateListDrawableBuilder setDefaultDrawable(float radius, int color) {
        return setDefaultDrawable(radius, color, 0, 0);
    }

    public StateListDrawableBuilder setDefaultDrawable(float radius, int color, int stokeWidth, int stokeColor) {
        defaultDrawable = new GradientDrawableBuilder().setRadius(radius).setSolid(color).setStroke(stokeWidth, stokeColor).create();
        return this;
    }

    public StateListDrawableBuilder setDisableDrawable(float radius, int color) {
        return setDisableDrawable(radius, color, 0, 0);
    }

    public StateListDrawableBuilder setDisableDrawable(float radius, int color, int stokeWidth, int stokeColor) {
        addState(-android.R.attr.state_enabled, radius, color, stokeWidth, stokeColor);
        return this;
    }

    public StateListDrawableBuilder setCheckedDrawable(float radius, int color) {
        return setCheckedDrawable(radius, color, 0, 0);
    }

    public StateListDrawableBuilder setCheckedDrawable(float radius, int color, int stokeWidth, int stokeColor) {
        addState(android.R.attr.state_checked, radius, color, stokeWidth, stokeColor);
        return this;
    }

    public StateListDrawableBuilder setSelectedDrawable(float radius, int color) {
        return setSelectedDrawable(radius, color, 0, 0);
    }

    public StateListDrawableBuilder setSelectedDrawable(float radius, int color, int stokeWidth, int stokeColor) {
        addState(android.R.attr.state_selected, radius, color, stokeWidth, stokeColor);
        return this;
    }

    public StateListDrawableBuilder setPressedDrawable(float radius, int color) {
        return setPressedDrawable(radius, color, 0, 0);
    }

    public StateListDrawableBuilder setPressedDrawable(float radius, int color, int stokeWidth, int stokeColor) {
        addState(android.R.attr.state_pressed, radius, color, stokeWidth, stokeColor);
        return this;
    }

    private void checkNull() {
        if (drawableStates == null) {
            drawableStates = new ArrayMap<>();
        }
    }

    private void addState(int attr, float radius, int color, int stokeWidth, int stokeColor) {
        checkNull();
        Drawable drawable = new GradientDrawableBuilder().setRadius(radius).setSolid(color).setStroke(stokeWidth, stokeColor).create();
        drawableStates.put(attr, drawable);
    }
}
