package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;
import com.duanlu.widget.wrapper.WidgetTextWrapper;

/********************************
 * @name SupportAutoCompleteTextView
 * @author 段露
 * @createDate 2019/07/30 11:59
 * @updateDate 2019/07/30 11:59
 * @version V1.0.0
 * @describe AutoCompleteTextView.
 ********************************/
public class SupportAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public SupportAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public SupportAutoCompleteTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
