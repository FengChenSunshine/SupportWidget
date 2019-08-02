package com.duanlu.widget.wrapper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

import com.duanlu.widget.utils.WidgetUtils;

/********************************
 * @name GradientDrawableWrapper
 * @author 段露
 * @createDate 2019/07/30 10:32
 * @updateDate 2019/07/30 10:32
 * @version V1.0.0
 * @describe GradientDrawable.
 ********************************/
final class GradientDrawableWrapper extends GradientDrawable {

    GradientDrawableWrapper(@NonNull TypedArray typedArray
                            //shape.
            , int shapeIndex
                            //solid.
            , int solidColorIndex
                            //size.
            , int sizeWidthIndex, int sizeHeightIndex
                            //corners.
            , int cornersRadiusIndex, int cornersTopLeftRadiusIndex, int cornersTopRightRadiusIndex
            , int cornersBottomLeftRadiusIndex, int cornersBottomRightRadiusIndex
                            //stroke.
            , int strokeColorIndex, int strokeWidthIndex, int strokeDashWidthIndex, int strokeDashGapIndex
                            //gradient.
            , int gradientStartColorIndex, int gradientCenterColorIndex, int gradientEndColorIndex
            , int gradientAngleIndex, int gradientCenterXIndex, int gradientCenterYIndex
            , int gradientRadiusIndex, int gradientTypeIndex, int gradientUseLevelIndex) {

        //shape.
        shape(typedArray, shapeIndex);
        //size.
        if (typedArray.hasValue(sizeWidthIndex) && typedArray.hasValue(sizeHeightIndex)) {
            size(typedArray, sizeWidthIndex, sizeHeightIndex);
        }
        //padding.
        //TODO no public method.
        //corners.
        corners(typedArray, cornersRadiusIndex, cornersTopLeftRadiusIndex, cornersTopRightRadiusIndex, cornersBottomLeftRadiusIndex, cornersBottomRightRadiusIndex);
        //stroke.
        stroke(typedArray, strokeColorIndex, strokeWidthIndex, strokeDashWidthIndex, strokeDashGapIndex);
        //solid or gradient.
        if (isGradient(typedArray, gradientStartColorIndex)) {
            gradient(typedArray, gradientStartColorIndex, gradientCenterColorIndex, gradientEndColorIndex
                    , gradientAngleIndex, gradientCenterXIndex, gradientCenterYIndex
                    , gradientRadiusIndex, gradientTypeIndex, gradientUseLevelIndex);
        } else {
            solid(typedArray, solidColorIndex);
        }
    }

    private void shape(@NonNull TypedArray typedArray, int shapeIndex) {
        if (typedArray.hasValue(shapeIndex)) {
            setShape(typedArray.getInt(shapeIndex, RECTANGLE));
        }
    }

    private void size(@NonNull TypedArray typedArray, int sizeWidthIndex, int sizeHeightIndex) {
        super.setSize(typedArray.getDimensionPixelOffset(sizeWidthIndex, -1)
                , typedArray.getDimensionPixelOffset(sizeHeightIndex, -1));
    }

    private void padding(@NonNull TypedArray typedArray) {
        //TODO padding.
    }

    private void corners(@NonNull TypedArray typedArray, int cornersRadiusIndex
            , int cornersTopLeftRadiusIndex, int cornersTopRightRadiusIndex
            , int cornersBottomLeftRadiusIndex, int cornersBottomRightRadiusIndex) {
        final float radius = typedArray.getDimension(cornersRadiusIndex, 0.0f);
        final float topLeftRadius = typedArray.getDimension(cornersTopLeftRadiusIndex, radius);
        final float topRightRadius = typedArray.getDimension(cornersTopRightRadiusIndex, radius);
        final float bottomRightRadius = typedArray.getDimension(cornersBottomRightRadiusIndex, radius);
        final float bottomLeftRadius = typedArray.getDimension(cornersBottomLeftRadiusIndex, radius);
        super.setCornerRadii(new float[]{topLeftRadius, topLeftRadius,
                topRightRadius, topRightRadius,
                bottomRightRadius, bottomRightRadius,
                bottomLeftRadius, bottomLeftRadius});
    }

    private void stroke(@NonNull TypedArray typedArray
            , int strokeColorIndex, int strokeWidthIndex, int strokeDashWidthIndex, int strokeDashGapIndex) {
        final ColorStateList colorStateLis = typedArray.getColorStateList(strokeColorIndex);
        final int width = typedArray.getDimensionPixelOffset(strokeWidthIndex, 0);
        final float dashWidth = typedArray.getDimension(strokeDashWidthIndex, 0.0f);
        final float dashGap = typedArray.getDimension(strokeDashGapIndex, 0.0f);
        if (null == colorStateLis) {
            super.setStroke(width, Color.TRANSPARENT, dashWidth, dashGap);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.setStroke(width, colorStateLis, dashWidth, dashGap);
        } else {
            final int color = colorStateLis.getColorForState(super.getState(), 0);
            super.setStroke(width, color, dashWidth, dashGap);
        }
    }

    private void solid(@ColorInt int color) {
        super.setColor(color);
    }

    private void solid(@NonNull TypedArray typedArray, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.setColor(typedArray.getColorStateList(index));
        } else {
            super.setColor(typedArray.getColor(index, Color.WHITE));
        }
    }

    private void gradient(@NonNull TypedArray typedArray
            , int startColorIndex, int centerColorIndex, int endColorIndex
            , int gradientAngleIndex, int gradientCenterXIndex, int gradientCenterYIndex
            , int gradientRadiusIndex, int gradientTypeIndex, int gradientUseLevelIndex) {

        final int startColor = WidgetUtils.getColor(typedArray, startColorIndex, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

            final boolean hasCenterColor = typedArray.hasValue(centerColorIndex);
            final int endColor = WidgetUtils.getColor(typedArray, endColorIndex, 0);

            if (hasCenterColor) {
                final int centerColor = WidgetUtils.getColor(typedArray, centerColorIndex, 0);

                final float centerX = WidgetUtils.getFloatOrFraction(typedArray, gradientCenterXIndex, 0.5f);
                final float centerY = WidgetUtils.getFloatOrFraction(typedArray, gradientCenterYIndex, 0.5f);

                super.setColors(new int[]{startColor, centerColor, endColor});
                super.setGradientCenter(centerX, centerY);
            } else {
                super.setColors(new int[]{startColor, endColor});
            }

            final int type = typedArray.getInt(gradientTypeIndex, GradientDrawable.LINEAR_GRADIENT);
            super.setGradientType(type);

            if (GradientDrawable.LINEAR_GRADIENT == type) {
                final int angle = typedArray.getInt(gradientAngleIndex, 0);
                switch (angle) {
                    case 0:
                        super.setOrientation(Orientation.LEFT_RIGHT);
                        break;
                    case 1:
                        super.setOrientation(Orientation.BL_TR);
                        break;
                    case 2:
                        super.setOrientation(Orientation.BOTTOM_TOP);
                        break;
                    case 3:
                        super.setOrientation(Orientation.BR_TL);
                        break;
                    case 4:
                        super.setOrientation(Orientation.RIGHT_LEFT);
                        break;
                    case 5:
                        super.setOrientation(Orientation.TR_BL);
                        break;
                    case 6:
                        super.setOrientation(Orientation.TOP_BOTTOM);
                        break;
                    case 7:
                        super.setOrientation(Orientation.TL_BR);
                        break;
                }
            } else {
                if (typedArray.hasValue(gradientRadiusIndex)) {
                    super.setGradientRadius(typedArray.getDimension(gradientRadiusIndex, 0.5f));
                }
            }

            super.setUseLevel(typedArray.getBoolean(gradientUseLevelIndex, false));

        } else {
            super.setColor(startColor);
        }
    }

    private boolean isGradient(@NonNull TypedArray typedArray, int startColorIndex) {
        return null != typedArray.getColorStateList(startColorIndex);
    }

}
