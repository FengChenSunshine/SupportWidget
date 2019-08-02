package com.duanlu.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.TextFeature;

/********************************
 * @name SupportTextView
 * @author 段露
 * @createDate 2019/07/30 14:26
 * @updateDate 2019/07/30 14:26
 * @version V1.0.0
 * @describe 带描边、渐变色等功能的AppCompatTextView.
 ********************************/
public class SupportFeatureTextView extends SupportTextView {

    private TextFeature mTextFeature;

    public SupportFeatureTextView(Context context) {
        this(context, null);
    }

    public SupportFeatureTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public SupportFeatureTextView(Context context, AttributeSet attrs, int defStyleAttr) {
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
