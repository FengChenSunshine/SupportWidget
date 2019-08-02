package com.duanlu.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;

/********************************
 * @name SupportView
 * @author 段露
 * @createDate 2019/07/29 18:14
 * @updateDate 2019/07/29 18:14
 * @version V1.0.0
 * @describe View.
 ********************************/
public class SupportView extends View {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportView(Context context) {
        this(context, null);
    }

    public SupportView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SupportView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SupportView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initView(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mWidgetDrawableWrapper = new WidgetDrawableWrapper(this, attrs, defStyleAttr, defStyleRes);
    }

    public WidgetDrawableWrapper getWidgetDrawableWrapper() {
        return mWidgetDrawableWrapper;
    }

}
