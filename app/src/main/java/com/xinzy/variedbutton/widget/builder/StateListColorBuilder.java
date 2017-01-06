package com.xinzy.variedbutton.widget.builder;

import android.content.res.ColorStateList;
import android.support.v4.util.ArrayMap;

import java.util.Map;

/**
 * Created by Xinzy on 2017-01-04.
 *
 */
public class StateListColorBuilder {

    private int defaultColor = 0xFF666666;
    private Map<Integer, Integer> stateColors;

    public ColorStateList create() {
        if (stateColors != null && stateColors.size() > 0) {
            final int size = stateColors.size();
            int[][] states = new int[size + 1][];
            int[] colors = new int[size + 1];
            int index = 0;
            for (Integer key : stateColors.keySet()) {
                states[index] = new int[] { key };
                colors[index] = stateColors.get(key);
                index ++;
            }
            states[size] = new int[] {};
            colors[size] = defaultColor;

            return new ColorStateList(states, colors);
        }

        return new ColorStateList(new int[][] {{}}, new int[] {defaultColor});
    }

    public StateListColorBuilder setDefaultColor(int color) {
        defaultColor = color;
        return this;
    }

    public StateListColorBuilder setDisableColor(int color) {
        checkNull();
        stateColors.put(-android.R.attr.state_enabled, color);
        return this;
    }

    public StateListColorBuilder setPressedColor(int color) {
        checkNull();
        stateColors.put(android.R.attr.state_pressed, color);
        return this;
    }

    public StateListColorBuilder setCheckedColor(int color) {
        checkNull();
        stateColors.put(android.R.attr.state_checked, color);
        return this;
    }

    public StateListColorBuilder setSelectedColor(int color) {
        checkNull();
        stateColors.put(android.R.attr.state_selected, color);
        return this;
    }

    private void checkNull() {
        if (stateColors == null) {
            stateColors = new ArrayMap<>();
        }
    }
}
