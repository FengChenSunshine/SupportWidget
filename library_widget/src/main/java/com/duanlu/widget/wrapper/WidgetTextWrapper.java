package com.duanlu.widget.wrapper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.duanlu.widget.R;

/********************************
 * @name WidgetTextWrapper
 * @author 段露
 * @createDate 2019/07/30 15:52
 * @updateDate 2019/07/30 15:52
 * @version V1.0.0
 * @describe WidgetTextWrapper.
 ********************************/
public class WidgetTextWrapper {

    private TextView mTarget;

    public WidgetTextWrapper(TextView target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mTarget = target;
        this.parseTypeArray(target, attrs, defStyleAttr, defStyleRes);
    }

    private void parseTypeArray(TextView target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = target.getContext().obtainStyledAttributes(attrs, R.styleable.SupportWidgetText, defStyleAttr, defStyleRes);

        if (typedArray.hasValue(R.styleable.SupportWidgetText_widget_text_color)) {
            setTextColor(typedArray);
        }
        if (typedArray.hasValue(R.styleable.SupportWidgetText_widget_hint_text_color)) {
            setHintTextColor(typedArray);
        }

        typedArray.recycle();
    }

    private void setTextColor(TypedArray typedArray) {
        ColorStateList colorStateList = ColorStateListWrapper.create(typedArray, mTarget.getCurrentTextColor()
                , R.styleable.SupportWidgetText_widget_text_color
                , R.styleable.SupportWidgetText_widget_disabled_text_color
                , R.styleable.SupportWidgetText_widget_pressed_text_color
                , R.styleable.SupportWidgetText_widget_selected_text_color
                , R.styleable.SupportWidgetText_widget_checked_text_color
                , R.styleable.SupportWidgetText_widget_focused_text_color);

        mTarget.setTextColor(colorStateList);
    }

    private void setHintTextColor(TypedArray typedArray) {
        ColorStateList colorStateList = ColorStateListWrapper.create(typedArray, mTarget.getCurrentHintTextColor()
                , R.styleable.SupportWidgetText_widget_hint_text_color
                , R.styleable.SupportWidgetText_widget_disabled_hint_text_color
                , R.styleable.SupportWidgetText_widget_pressed_hint_text_color
                , R.styleable.SupportWidgetText_widget_selected_hint_text_color
                , R.styleable.SupportWidgetText_widget_checked_hint_text_color
                , R.styleable.SupportWidgetText_widget_focused_hint_text_color);

        mTarget.setHintTextColor(colorStateList);
    }

}
