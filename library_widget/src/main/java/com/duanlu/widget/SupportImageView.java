package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;

/********************************
 * @name SupportImageView
 * @author 段露
 * @createDate 2019/07/30 11:50
 * @updateDate 2019/07/30 11:50
 * @version V1.0.0
 * @describe AppCompatImageView.
 ********************************/
public class SupportImageView extends AppCompatImageView {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportImageView(Context context) {
        this(context, null);
    }

    public SupportImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SupportImageView(Context context, AttributeSet attrs, int defStyleAttr) {
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
