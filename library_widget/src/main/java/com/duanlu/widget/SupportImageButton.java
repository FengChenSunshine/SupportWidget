package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;

/********************************
 * @name SupportImageButton
 * @author 段露
 * @createDate 2019/07/30 11:53
 * @updateDate 2019/07/30 11:53
 * @version V1.0.0
 * @describe AppCompatImageButton.
 ********************************/
public class SupportImageButton extends AppCompatImageButton {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportImageButton(Context context) {
        this(context, null);
    }

    public SupportImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.imageButtonStyle);
    }

    public SupportImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        mWidgetDrawableWrapper = new WidgetDrawableWrapper(this, attrs, defStyleAttr, 0);
    }

    public WidgetDrawableWrapper getWidgetDrawableWrapper() {
        return mWidgetDrawableWrapper;
    }

}
