package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;
import com.duanlu.widget.wrapper.WidgetTextWrapper;

/********************************
 * @name SupportCheckBox
 * @author 段露
 * @createDate 2019/07/30 10:04
 * @updateDate 2019/07/30 10:04
 * @version V1.0.0
 * @describe AppCompatCheckBox.
 ********************************/
public class SupportCheckBox extends AppCompatCheckBox {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportCheckBox(Context context) {
        this(context, null);
    }

    public SupportCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.checkboxStyle);
    }

    public SupportCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        mWidgetDrawableWrapper = new WidgetDrawableWrapper(this, attrs, defStyleAttr, 0);
        new WidgetTextWrapper(this, attrs, defStyleAttr, 0);
    }

    public WidgetDrawableWrapper getWidgetDrawableWrapper() {
        return mWidgetDrawableWrapper;
    }

}
