package com.duanlu.widget.constants;

/********************************
 * @name WidgetConstants
 * @author 段露
 * @createDate 2019/07/30 10:50
 * @updateDate 2019/07/30 10:50
 * @version V1.0.0
 * @describe Constants.
 ********************************/
public final class WidgetConstants {

    public static final int[] DISABLED = new int[]{-android.R.attr.state_enabled};
    public static final int[] ENABLED = new int[]{android.R.attr.state_enabled};
    public static final int[] SELECTED = new int[]{android.R.attr.state_selected};
    public static final int[] CHECKABLE = new int[]{android.R.attr.state_checkable};
    public static final int[] CHECKED = new int[]{android.R.attr.state_checked};
    public static final int[] FOCUSED = new int[]{android.R.attr.state_focused};
    public static final int[] PRESSED = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
    public static final int[] NORMAL = new int[]{};

    public static final int[][] STATUS = new int[][]{DISABLED, PRESSED, SELECTED, CHECKED, FOCUSED, NORMAL};
    public static final int[][] STATUS_NO_CHECKED = new int[][]{DISABLED, PRESSED, SELECTED, FOCUSED, NORMAL};
    //enabled=false;
    //pressed=true、enabled=true.
    //selected=true.
    //focused=true.
    //default.

}
