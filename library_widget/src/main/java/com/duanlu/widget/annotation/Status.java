package com.duanlu.widget.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/********************************
 * @name Status
 * @author 段露
 * @createDate 2019/07/30 16:44
 * @updateDate 2019/07/30 16:44
 * @version V1.0.0
 * @describe 状态.
 ********************************/
@IntDef({Status.NORMAL, Status.PRESSED, Status.FOCUSED, Status.CHECKED
        , Status.CHECKABLE, Status.SELECTED, Status.ENABLED, Status.DISABLED})
@Retention(RetentionPolicy.CLASS)
public @interface Status {

    int DISABLED = 7;
    int ENABLED = 6;
    int SELECTED = 5;
    int CHECKABLE = 4;
    int CHECKED = 3;
    int FOCUSED = 2;
    int PRESSED = 1;
    int NORMAL = 0;

}
