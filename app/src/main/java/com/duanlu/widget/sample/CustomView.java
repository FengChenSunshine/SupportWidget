package com.duanlu.widget.sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.duanlu.widget.wrapper.WidgetDrawableWrapper;

/********************************
 * @name CustomView
 * @author 段露
 * @company 浙江托普云农科技股份有限公司
 * @createDate 2019/08/02 09:00
 * @updateDate 2019/08/02 09:00
 * @version V1.0.0
 * @describe TODO
 ********************************/
public class CustomView extends View {

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.initView(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        //实现背景选择器功能.
        new WidgetDrawableWrapper(this, attrs, defStyleAttr, defStyleRes);
        //实现文本颜色选择器功能(注意：第一个参数必须是TextView的子类).
        //new WidgetTextWrapper(this, attrs, defStyleAttr, defStyleRes);
        //实现文本描边、渐变等功能(注意：第一个参数必须是TextView的子类).
        //new TextFeature(this, attrs, defStyleAttr, defStyleRes);
        //实现图片着色、旋转灯等功能(注意：第一个参数必须是AppCompatImageView的子类).
        //new ImageFeature(this, attrs, defStyleAttr, defStyleRes);
    }

}
