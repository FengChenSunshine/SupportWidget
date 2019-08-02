package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;
import com.duanlu.widget.wrapper.WidgetTextWrapper;

/********************************
 * @name SupportButton
 * @author 段露
 * @createDate 2019/07/29 18:10
 * @updateDate 2019/07/29 18:10
 * @version V1.0.0
 * @describe AppCompatEditText.
 ********************************/
public class SupportEditText extends AppCompatEditText {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportEditText(Context context) {
        this(context, null);
    }

    public SupportEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.editTextStyle);
    }

    public SupportEditText(Context context, AttributeSet attrs, int defStyleAttr) {
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
