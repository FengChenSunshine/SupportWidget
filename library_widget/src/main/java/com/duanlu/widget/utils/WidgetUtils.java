package com.duanlu.widget.utils;

import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.util.TypedValue;

/********************************
 * @name WidgetUtils
 * @author 段露
 * @createDate 2019/07/30 10:49
 * @updateDate 2019/07/30 10:49
 * @version V1.0.0
 * @describe Utils.
 ********************************/
public final class WidgetUtils {

    public static int getColor(@NonNull TypedArray typedArray, int index, int defaultColor) {
        return typedArray.getColor(index, defaultColor);
    }

    public static float getFloatOrFraction(TypedArray a, int index, float defaultValue) {
        TypedValue tv = a.peekValue(index);
        if (tv != null) {
            boolean vIsFraction = tv.type == TypedValue.TYPE_FRACTION;
            return vIsFraction ? tv.getFraction(1.0f, 1.0f) : tv.getFloat();
        }
        return defaultValue;
    }

    public static boolean addIfExistColorWithState(int color, int[] colors, int states[][], int[] state, int index) {
        if (1 != color) {
            colors[index] = color;
            states[index] = state;
            return true;
        }
        return false;
    }

}
