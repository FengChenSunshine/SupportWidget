package com.duanlu.widget.wrapper;

import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.duanlu.widget.R;
import com.duanlu.widget.utils.WidgetUtils;

/********************************
 * @name ImageFeature
 * @author 段露
 * @createDate 2019/08/01 10:55
 * @updateDate 2019/08/01 10:55
 * @version V1.0.0
 * @describe Tint(着色)等功能实现.
 ********************************/
public final class ImageFeature {

    private AppCompatImageView mTarget;
    private Float mRotateDegrees;

    public ImageFeature(AppCompatImageView target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mTarget = target;
        this.parseTypeArray(target, attrs, defStyleAttr, defStyleRes);
    }

    private void parseTypeArray(AppCompatImageView target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = target.getContext().obtainStyledAttributes(attrs, R.styleable.SupportWidgetImageFeature, defStyleAttr, defStyleRes);

        parseTintColor(typedArray);
        parseRotateDegrees(typedArray);

        typedArray.recycle();
    }

    /**
     * 解析Tint参数.
     */
    private void parseTintColor(TypedArray typedArray) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ColorStateListWrapper tintColor = ColorStateListWrapper.parseCreate(typedArray
                    , R.styleable.SupportWidgetImageFeature_widget_src_tint
                    , R.styleable.SupportWidgetImageFeature_widget_disabled_src_tint
                    , R.styleable.SupportWidgetImageFeature_widget_pressed_src_tint
                    , R.styleable.SupportWidgetImageFeature_widget_selected_src_tint
                    , R.styleable.SupportWidgetImageFeature_widget_checked_src_tint
                    , R.styleable.SupportWidgetImageFeature_widget_focused_src_tint);
            if (null != tintColor) mTarget.setImageTintList(tintColor);
        }
    }

    /**
     * 解析RotateDegrees参数.
     */
    private void parseRotateDegrees(TypedArray typedArray) {
        if (typedArray.hasValue(R.styleable.SupportWidgetImageFeature_widget_src_rotate_degrees)) {
            this.mRotateDegrees = WidgetUtils.getFloatOrFraction(typedArray, R.styleable.SupportWidgetImageFeature_widget_src_rotate_degrees, 0);
        }
    }

    @Nullable
    public Float getRotateDegrees() {
        return mRotateDegrees;
    }

    public void setRotateDegrees(float rotateDegrees) {
        this.mRotateDegrees = rotateDegrees;
        mTarget.invalidate();
    }

}
