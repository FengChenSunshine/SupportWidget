package com.duanlu.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;

/********************************
 * @name SupportRadioGroup
 * @author 段露
 * @createDate 2019/07/30 11:48
 * @updateDate 2019/07/30 11:48
 * @version V1.0.0
 * @describe RadioGroup.
 ********************************/
public class SupportRadioGroup extends RadioGroup {

    private WidgetDrawableWrapper mWidgetDrawableWrapper;

    public SupportRadioGroup(Context context) {
        super(context);
        this.initView(context, null, 0);
    }

    public SupportRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView(context, attrs, 0);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        mWidgetDrawableWrapper = new WidgetDrawableWrapper(this, attrs, defStyleAttr, 0);
    }

    public WidgetDrawableWrapper getWidgetDrawableWrapper() {
        return mWidgetDrawableWrapper;
    }

}
