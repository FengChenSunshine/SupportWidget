package com.duanlu.widget.wrapper;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

import com.duanlu.widget.R;
import com.duanlu.widget.annotation.Status;
import com.duanlu.widget.constants.WidgetConstants;
import com.duanlu.widget.utils.WidgetUtils;

/********************************
 * @name WidgetDrawableWrapper
 * @author 段露
 * @createDate 2019/07/29 09:09
 * @updateDate 2019/07/29 09:09
 * @version V1.0.0
 * @describe WidgetDrawableWrapper.
 ********************************/
public final class WidgetDrawableWrapper {

    private View mTarget;

    private GradientDrawableWrapper mDisabledDrawable;
    private GradientDrawableWrapper mPressedDrawable;
    private GradientDrawableWrapper mSelectedDrawable;
    private GradientDrawableWrapper mFocusedDrawable;
    private GradientDrawableWrapper mDefaultDrawable;

    private RippleDrawable mRippleDrawable;

    public WidgetDrawableWrapper(View target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mTarget = target;
        this.parseTypeArray(target, attrs, defStyleAttr, defStyleRes);
    }

    private void parseTypeArray(View target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = target.getContext().obtainStyledAttributes(attrs, R.styleable.SupportWidgetBackgroundDrawable, defStyleAttr, defStyleRes);

        //background.
        parseBackground(target, typedArray);
        //ripple.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            parseRipple(target, typedArray);
        }
        typedArray.recycle();
    }

    private void parseBackground(View target, TypedArray typedArray) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        //enabled=false.
        if (hasState(typedArray, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_solid
                , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_start_color
                , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_stroke_color)) {
            mDisabledDrawable = new GradientDrawableWrapper(typedArray
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_shape
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_solid
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_size_width, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_size_height
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_corners_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_corners_top_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_corners_top_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_corners_bottom_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_corners_bottom_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_stroke_color, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_stroke_width, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_stroke_dash_width, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_stroke_dash_gap
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_start_color, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_center_color, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_end_color
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_angle, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_center_x, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_center_y
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_type, R.styleable.SupportWidgetBackgroundDrawable_widget_disabled_gradient_use_level);
            stateListDrawable.addState(WidgetConstants.DISABLED, mDisabledDrawable);
        }
        //pressed=true.
        if (hasState(typedArray, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_solid
                , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_start_color
                , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_stroke_color)) {
            mPressedDrawable = new GradientDrawableWrapper(typedArray
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_shape
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_solid
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_size_width, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_size_height
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_corners_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_corners_top_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_corners_top_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_corners_bottom_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_corners_bottom_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_stroke_color, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_stroke_width, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_stroke_dash_width, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_stroke_dash_gap
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_start_color, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_center_color, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_end_color
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_angle, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_center_x, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_center_y
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_type, R.styleable.SupportWidgetBackgroundDrawable_widget_pressed_gradient_use_level);
            stateListDrawable.addState(WidgetConstants.PRESSED, mPressedDrawable);
        }
        //selected=true.
        if (hasState(typedArray, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_solid
                , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_start_color
                , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_stroke_color)) {
            mSelectedDrawable = new GradientDrawableWrapper(typedArray
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_shape
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_solid
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_size_width, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_size_height
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_corners_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_corners_top_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_corners_top_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_corners_bottom_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_corners_bottom_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_stroke_color, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_stroke_width, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_stroke_dash_width, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_stroke_dash_gap
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_start_color, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_center_color, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_end_color
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_angle, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_center_x, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_center_y
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_type, R.styleable.SupportWidgetBackgroundDrawable_widget_selected_gradient_use_level);
            stateListDrawable.addState(WidgetConstants.SELECTED, mSelectedDrawable);
        }
        //checked=true.
        if (target instanceof Checkable) {//eg:CompoundButton及其子类.
            //TODO implements.
        }
        //focused=true.
        if (hasState(typedArray, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_solid
                , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_start_color
                , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_stroke_color)) {
            mFocusedDrawable = new GradientDrawableWrapper(typedArray
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_shape
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_solid
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_size_width, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_size_height
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_corners_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_corners_top_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_corners_top_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_corners_bottom_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_corners_bottom_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_stroke_color, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_stroke_width, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_stroke_dash_width, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_stroke_dash_gap
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_start_color, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_center_color, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_end_color
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_angle, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_center_x, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_center_y
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_type, R.styleable.SupportWidgetBackgroundDrawable_widget_focused_gradient_use_level);
            stateListDrawable.addState(WidgetConstants.FOCUSED, mFocusedDrawable);
        }
        //default.
        if (hasState(typedArray, R.styleable.SupportWidgetBackgroundDrawable_widget_solid
                , R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_start_color
                , R.styleable.SupportWidgetBackgroundDrawable_widget_stroke_color)) {
            mDefaultDrawable = new GradientDrawableWrapper(typedArray
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_shape
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_solid
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_size_width, R.styleable.SupportWidgetBackgroundDrawable_widget_size_height
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_corners_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_corners_top_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_corners_top_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_corners_bottom_left_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_corners_bottom_right_radius
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_stroke_color, R.styleable.SupportWidgetBackgroundDrawable_widget_stroke_width, R.styleable.SupportWidgetBackgroundDrawable_widget_stroke_dash_width, R.styleable.SupportWidgetBackgroundDrawable_widget_stroke_dash_gap
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_start_color, R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_center_color, R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_end_color
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_angle, R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_center_x, R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_center_y
                    , R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_radius, R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_type, R.styleable.SupportWidgetBackgroundDrawable_widget_gradient_use_level);

            stateListDrawable.addState(WidgetConstants.NORMAL, mDefaultDrawable);
        }

        if (null != stateListDrawable.getCurrent()) {
            ViewCompat.setBackground(target, stateListDrawable);
        }
    }

    private void parseRipple(View target, TypedArray typedArray) {
        if (typedArray.getBoolean(R.styleable.SupportWidgetBackgroundDrawable_widget_ripple_enabled, true)) {
            int rippleColor;
            if (typedArray.hasValue(R.styleable.SupportWidgetBackgroundDrawable_widget_ripple_color)) {
                rippleColor = WidgetUtils.getColor(typedArray, R.styleable.SupportWidgetBackgroundDrawable_widget_ripple_color, 0);
            } else {
                TypedArray a = target.getContext().obtainStyledAttributes(new int[]{android.support.v7.appcompat.R.attr.colorControlHighlight});
                rippleColor = typedArray.getColor(0, Color.parseColor("#1f000000"));//#33ffffff
                a.recycle();
            }
            this.setRippleColor(rippleColor);
        }
    }

    private boolean hasState(@NonNull TypedArray typedArray, int solidColorIndex, int startColorIndex, int strokeColorIndex) {
        return null != typedArray.getColorStateList(solidColorIndex)
                || null != typedArray.getColorStateList(startColorIndex)
                || null != typedArray.getColorStateList(strokeColorIndex);
    }

    private GradientDrawableWrapper getDrawableByStatus(@Status int status) {
        switch (status) {
            case Status.NORMAL:
            case Status.ENABLED:
                return mDefaultDrawable;
            case Status.PRESSED:
                return mPressedDrawable;
            case Status.FOCUSED:
                return mFocusedDrawable;
            case Status.CHECKED:
                return null;
            case Status.CHECKABLE:
                return null;
            case Status.SELECTED:
                return mSelectedDrawable;
            case Status.DISABLED:
                return mDisabledDrawable;
        }
        return null;
    }

    public WidgetDrawableWrapper setRippleColor(@ColorInt int color) {
        return setRippleColor(ColorStateList.valueOf(color));
    }

    public WidgetDrawableWrapper setRippleColor(ColorStateList color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != mRippleDrawable) {
                mRippleDrawable.setColor(color);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mRippleDrawable = new RippleDrawable(color, null, mTarget.getBackground());
                mTarget.setForeground(mRippleDrawable);
            } else {
                mRippleDrawable = new RippleDrawable(color, mTarget.getBackground(), null);
                mTarget.setBackground(mRippleDrawable);
            }
        }
        return this;
    }

    public WidgetDrawableWrapper setSize(@Status int status, int width, int height) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setSize(width, height);
        return this;
    }

    public WidgetDrawableWrapper setCorners(@Status int status, float radius) {
        return setCorners(status, radius, radius, radius, radius);
    }

    public WidgetDrawableWrapper setCorners(@Status int status, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) {
            drawable.setCornerRadii(new float[]{topLeftRadius, topLeftRadius,
                    topRightRadius, topRightRadius,
                    bottomRightRadius, bottomRightRadius,
                    bottomLeftRadius, bottomLeftRadius});
        }
        return this;
    }

    public WidgetDrawableWrapper setStroke(@Status int status, int strokeWidth, @ColorInt int strokeColor) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setStroke(strokeWidth, strokeColor);
        return this;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WidgetDrawableWrapper setStroke(@Status int status, int strokeWidth, @NonNull ColorStateList strokeColor) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setStroke(strokeWidth, strokeColor);
        return this;
    }

    public WidgetDrawableWrapper setStroke(@Status int status, int strokeWidth, @ColorInt int strokeColor, int strokeDashWidth, int strokeDashGap) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) {
            drawable.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);
        }
        return this;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WidgetDrawableWrapper setStroke(@Status int status, int strokeWidth, @NonNull ColorStateList strokeColor, int strokeDashWidth, int strokeDashGap) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) {
            drawable.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);
        }
        return this;
    }

    public WidgetDrawableWrapper setSolidColor(@Status int status, @ColorInt int color) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setColor(color);
        return this;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public WidgetDrawableWrapper setSolidColor(@Status int status, @NonNull ColorStateList colorStateList) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setColor(colorStateList);
        return this;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public WidgetDrawableWrapper setColors(@Status int status, int startColor, int endColor) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setColors(new int[]{startColor, endColor});
        return this;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public WidgetDrawableWrapper setColors(@Status int status, int startColor, int centerColor, int endColor) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setColors(new int[]{startColor, centerColor, endColor});
        return this;
    }

    public WidgetDrawableWrapper setGradientCenter(@Status int status, float x, float y) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setGradientCenter(x, y);
        return this;
    }

    public WidgetDrawableWrapper setGradientType(@Status int status, int gradientType) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setGradientType(gradientType);
        return this;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public WidgetDrawableWrapper setOrientation(@Status int status, GradientDrawable.Orientation orientation) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setOrientation(orientation);
        return this;
    }

    public WidgetDrawableWrapper setGradientRadius(@Status int status, float gradientRadius) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setGradientRadius(gradientRadius);
        return this;
    }

    public WidgetDrawableWrapper setUseLevel(@Status int status, boolean useLevel) {
        GradientDrawableWrapper drawable = getDrawableByStatus(status);
        if (null != drawable) drawable.setUseLevel(useLevel);
        return this;
    }

}
