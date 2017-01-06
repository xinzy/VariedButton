package com.xinzy.variedbutton.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.xinzy.variedbutton.R;
import com.xinzy.variedbutton.widget.builder.StateListColorBuilder;
import com.xinzy.variedbutton.widget.builder.StateListDrawableBuilder;

/**
 * Created by Xinzy on 2017-01-04.
 * 多变背景的按钮控件
 *
 */
public class VariedButton extends TextView {

    protected Context mContext;

    public VariedButton(Context context) {
        this(context, null);
    }

    public VariedButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VariedButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public VariedButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;

        TypedArray ta = mContext.obtainStyledAttributes(attrs, R.styleable.VariedButton);

        StateListDrawableBuilder drawableBuilder = new StateListDrawableBuilder();
        StateListColorBuilder colorBuilder = new StateListColorBuilder();

        float radius = ta.getDimension(R.styleable.VariedButton_radius, 0);

        // default values
        if (ta.hasValue(R.styleable.VariedButton_strokeWidth)
                || ta.hasValue(R.styleable.VariedButton_strokeColor)
                || ta.hasValue(R.styleable.VariedButton_solidColor)
                ) {

            drawableBuilder.setDefaultDrawable(radius, ta.getColor(R.styleable.VariedButton_solidColor, 0),
                    ta.getDimensionPixelSize(R.styleable.VariedButton_strokeWidth, 0),
                    ta.getColor(R.styleable.VariedButton_strokeColor, 0));
        }
        int textColor = ta.getColor(R.styleable.VariedButton_textColor, 0);
        if (textColor == 0) {
            textColor = getCurrentTextColor();
        }
        colorBuilder.setDefaultColor(textColor);

        // pressed values
        if (ta.hasValue(R.styleable.VariedButton_pressedStrokeWidth)
                || ta.hasValue(R.styleable.VariedButton_pressedStrokeColor)
                || ta.hasValue(R.styleable.VariedButton_pressedSolidColor)
                ) {

            drawableBuilder.setPressedDrawable(radius, ta.getColor(R.styleable.VariedButton_pressedSolidColor, 0),
                    ta.getDimensionPixelSize(R.styleable.VariedButton_pressedStrokeWidth, 0),
                    ta.getColor(R.styleable.VariedButton_pressedStrokeColor, 0));
        }
        if (ta.hasValue(R.styleable.VariedButton_pressedTextColor)) {
            colorBuilder.setPressedColor(ta.getColor(R.styleable.VariedButton_pressedTextColor, 0));
        }

        // selected values
        if (ta.hasValue(R.styleable.VariedButton_selectedStrokeWidth)
                || ta.hasValue(R.styleable.VariedButton_selectedStrokeColor)
                || ta.hasValue(R.styleable.VariedButton_selectedSolidColor)
                ) {

            drawableBuilder.setSelectedDrawable(radius, ta.getColor(R.styleable.VariedButton_selectedSolidColor, 0),
                    ta.getDimensionPixelSize(R.styleable.VariedButton_selectedStrokeWidth, 0),
                    ta.getColor(R.styleable.VariedButton_selectedStrokeColor, 0));
        }
        if (ta.hasValue(R.styleable.VariedButton_selectedTextColor)) {
            colorBuilder.setSelectedColor(ta.getColor(R.styleable.VariedButton_selectedTextColor, 0));
        }

        // disable values
        if (ta.hasValue(R.styleable.VariedButton_disableStrokeWidth)
                || ta.hasValue(R.styleable.VariedButton_disableStrokeColor)
                || ta.hasValue(R.styleable.VariedButton_disableSolidColor)
                ) {

            drawableBuilder.setDisableDrawable(radius, ta.getColor(R.styleable.VariedButton_disableSolidColor, 0),
                    ta.getDimensionPixelSize(R.styleable.VariedButton_disableStrokeWidth, 0),
                    ta.getColor(R.styleable.VariedButton_disableStrokeColor, 0));
        }
        if (ta.hasValue(R.styleable.VariedButton_disableTextColor)) {
            colorBuilder.setDisableColor(ta.getColor(R.styleable.VariedButton_disableTextColor, 0));
        }

        setBackgroundDrawable(drawableBuilder.create());
        setTextColor(colorBuilder.create());

        ta.recycle();

        setGravity(Gravity.CENTER);
        setClickable(true);
    }
}
