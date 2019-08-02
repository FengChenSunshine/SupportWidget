package com.duanlu.widget;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;

/********************************
 * @name SupportSearchView
 * @author 段露
 * @createDate 2019/07/30 11:55
 * @updateDate 2019/07/30 11:55
 * @version V1.0.0
 * @describe SearchView.
 ********************************/
public class SupportSearchView extends SearchView {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportSearchView(Context context) {
        this(context, null);
    }

    public SupportSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.searchViewStyle);
    }

    public SupportSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
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
