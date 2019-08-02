package com.duanlu.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.TextFeature;

/********************************
 * @name SupportTextView
 * @author 段露
 * @createDate 2019/07/31 12:09
 * @updateDate 2019/07/31 12:09
 * @version V1.0.0
 * @describe 带描边、渐变色等功能的SSupportButton.
 ********************************/
public class SupportFeatureButton extends SupportButton {

    private TextFeature mTextFeature;

    public SupportFeatureButton(Context context) {
        this(context, null);
    }

    public SupportFeatureButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.buttonStyle);
    }

    public SupportFeatureButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr, 0);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mTextFeature = new TextFeature(this, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (null != mTextFeature) mTextFeature.invalidateShader();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mTextFeature.isContour()) {
            mTextFeature.prepareDrawContour();
            super.onDraw(canvas);
            mTextFeature.prepareSuperDraw();
        }
        super.onDraw(canvas);
    }

    public TextFeature getTextFeature() {
        return mTextFeature;
    }

}
