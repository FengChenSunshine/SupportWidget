package com.duanlu.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.duanlu.widget.wrapper.ImageFeature;

/********************************
 * @name SupportFeatureImageView
 * @author 段露
 * @createDate 2019/08/01 10:53
 * @updateDate 2019/08/01 10:53
 * @version V1.0.0
 * @describe 带Tint(着色)等功能的SupportImageView.
 ********************************/
public class SupportFeatureImageView extends SupportImageView {

    private ImageFeature mImageFeature;

    public SupportFeatureImageView(Context context) {
        this(context, null);
    }

    public SupportFeatureImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SupportFeatureImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initView(context, attrs, defStyleAttr, 0);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        mImageFeature = new ImageFeature(this, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        Float rotateDegrees = mImageFeature.getRotateDegrees();
        if (null != rotateDegrees && null != drawable) {
            canvas.save();
            canvas.rotate(rotateDegrees, getWidth() / 2.0f, getHeight() / 2.0f);
            super.onDraw(canvas);
            canvas.restore();
        } else {
            super.onDraw(canvas);
        }
    }

    public ImageFeature getImageFeature() {
        return mImageFeature;
    }

}
