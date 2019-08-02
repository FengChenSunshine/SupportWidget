package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;
import com.duanlu.widget.wrapper.WidgetTextWrapper;

/********************************
 * @name SupportMultiAutoCompleteTextView
 * @author 段露
 * @createDate 2019/07/30 12:00
 * @updateDate 2019/07/30 12:00
 * @version V1.0.0
 * @describe MultiAutoCompleteTextView.
 ********************************/
public class SupportMultiAutoCompleteTextView extends AppCompatMultiAutoCompleteTextView {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public SupportMultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public SupportMultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
