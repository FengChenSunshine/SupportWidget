package com.duanlu.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;

/********************************
 * @name SupportViewGroup
 * @author 段露
 * @createDate 2019/07/30 12:04
 * @updateDate 2019/07/30 12:04
 * @version V1.0.0
 * @describe ViewGroup.
 ********************************/
public abstract class SupportViewGroup extends ViewGroup {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportViewGroup(Context context) {
        this(context, null);
    }

    public SupportViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SupportViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SupportViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initView(context, attrs, defStyleAttr, 0);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mWidgetDrawableWrapper = new WidgetDrawableWrapper(this, attrs, defStyleAttr, defStyleRes);
    }

    public WidgetDrawableWrapper getWidgetDrawableWrapper() {
        return mWidgetDrawableWrapper;
    }

}
