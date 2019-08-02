package com.duanlu.widget.wrapper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;

import com.duanlu.widget.constants.WidgetConstants;
import com.duanlu.widget.utils.WidgetUtils;

/********************************
 * @name ColorStateListWrapper
 * @author 段露
 * @createDate 2019/07/30 10:48
 * @updateDate 2019/07/30 10:48
 * @version V1.0.0
 * @describe ColorStateList.
 ********************************/
public class ColorStateListWrapper extends ColorStateList {

    static ColorStateListWrapper create(TypedArray typedArray, int defaultColor
            , int colorIndex
            , int disabledColorIndex
            , int pressedColorIndex
            , int selectedColorIndex
            , int checkedColorIndex
            , int focusedColorIndex) {

        int[][] states;
        int[] colors;
        if (typedArray.hasValue(checkedColorIndex)) {
            states = WidgetConstants.STATUS;

            colors = new int[6];
            colors[5] = WidgetUtils.getColor(typedArray, colorIndex, defaultColor);
            colors[0] = WidgetUtils.getColor(typedArray, disabledColorIndex, colors[5]);
            colors[1] = WidgetUtils.getColor(typedArray, pressedColorIndex, colors[5]);
            colors[2] = WidgetUtils.getColor(typedArray, selectedColorIndex, colors[5]);
            colors[3] = WidgetUtils.getColor(typedArray, checkedColorIndex, colors[5]);
            colors[4] = WidgetUtils.getColor(typedArray, focusedColorIndex, colors[5]);
        } else {
            states = WidgetConstants.STATUS_NO_CHECKED;

            colors = new int[5];
            colors[4] = WidgetUtils.getColor(typedArray, colorIndex, defaultColor);
            colors[0] = WidgetUtils.getColor(typedArray, disabledColorIndex, colors[4]);
            colors[1] = WidgetUtils.getColor(typedArray, pressedColorIndex, colors[4]);
            colors[2] = WidgetUtils.getColor(typedArray, selectedColorIndex, colors[4]);
            colors[3] = WidgetUtils.getColor(typedArray, focusedColorIndex, colors[4]);
        }
        return new ColorStateListWrapper(states, colors);
    }

    @Nullable
    static ColorStateListWrapper parseCreate(TypedArray typedArray
            , int colorIndex
            , int disabledColorIndex
            , int pressedColorIndex
            , int selectedColorIndex
            , int checkedColorIndex
            , int focusedColorIndex) {
        int color = WidgetUtils.getColor(typedArray, colorIndex, 1);
        int disabledColor = WidgetUtils.getColor(typedArray, disabledColorIndex, 1);
        int pressedColor = WidgetUtils.getColor(typedArray, pressedColorIndex, 1);
        int selectedColor = WidgetUtils.getColor(typedArray, selectedColorIndex, 1);
        int checkedColor = WidgetUtils.getColor(typedArray, checkedColorIndex, 1);
        int focusedColor = WidgetUtils.getColor(typedArray, focusedColorIndex, 1);

        int N = 6 - (1 == color ? 1 : 0)
                - (1 == disabledColor ? 1 : 0)
                - (1 == pressedColor ? 1 : 0)
                - (1 == selectedColor ? 1 : 0)
                - (1 == checkedColor ? 1 : 0)
                - (1 == focusedColor ? 1 : 0);
        if (N > 0) {
            int[] colors = new int[N];
            int[][] states = new int[N][];
            int index = 0;

            if (WidgetUtils.addIfExistColorWithState(disabledColor, colors, states, WidgetConstants.DISABLED, index)) {
                index++;
            }
            if (WidgetUtils.addIfExistColorWithState(pressedColor, colors, states, WidgetConstants.PRESSED, index)) {
                index++;
            }
            if (WidgetUtils.addIfExistColorWithState(selectedColor, colors, states, WidgetConstants.SELECTED, index)) {
                index++;
            }
            if (WidgetUtils.addIfExistColorWithState(checkedColor, colors, states, WidgetConstants.CHECKED, index)) {
                index++;
            }
            if (WidgetUtils.addIfExistColorWithState(focusedColor, colors, states, WidgetConstants.FOCUSED, index)) {
                index++;
            }
            WidgetUtils.addIfExistColorWithState(color, colors, states, WidgetConstants.NORMAL, index);

            return new ColorStateListWrapper(states, colors);
        }
        return null;
    }

    private ColorStateListWrapper(int[][] states, int[] colors) {
        super(states, colors);
    }

}
