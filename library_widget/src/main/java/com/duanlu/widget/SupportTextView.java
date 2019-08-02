package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;
import com.duanlu.widget.wrapper.WidgetTextWrapper;

/********************************
 * @name SupportTextView
 * @author 段露
 * @createDate 2019/07/30 11:19
 * @updateDate 2019/07/30 11:19
 * @version V1.0.0
 * @describe AppCompatTextView.
 ********************************/
public class SupportTextView extends AppCompatTextView {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportTextView(Context context) {
        this(context, null);
    }

    public SupportTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public SupportTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr, 0);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mWidgetDrawableWrapper = new WidgetDrawableWrapper(this, attrs, defStyleAttr, defStyleRes);
        new WidgetTextWrapper(this, attrs, defStyleAttr, 0);
    }

    public WidgetDrawableWrapper getWidgetDrawableWrapper() {
        return mWidgetDrawableWrapper;
    }

}
