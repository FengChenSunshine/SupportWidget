package com.duanlu.widget.wrapper;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.duanlu.widget.R;
import com.duanlu.widget.utils.WidgetUtils;

/********************************
 * @name TextFeature
 * @author 段露
 * @createDate 2019/07/30 14:57
 * @updateDate 2019/07/30 14:57
 * @version V1.0.0
 * @describe 文字描边、渐变等功能实现.
 ********************************/
public final class TextFeature {

    private TextView mTarget;
    private boolean isContour;//是否描边:true描边,false不描边.
    private ColorStateList mContourColor;
    private float mContourWidth;

    private ColorStateList mSaveTargetColor;
    private float mSaveTargetWidth;
    private Shader mSaveTargetShader;

    private int[] mShaderColors;
    private float[] mShaderPosition;

    public TextFeature(TextView target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mTarget = target;
        this.parseTypeArray(target, attrs, defStyleAttr, defStyleRes);
    }

    private void parseTypeArray(TextView target, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = target.getContext().obtainStyledAttributes(attrs, R.styleable.SupportWidgetFeature, defStyleAttr, defStyleRes);

        parseContour(typedArray);
        parseShader(typedArray);

        typedArray.recycle();
    }

    /**
     * 解析描边参数.
     */
    private void parseContour(TypedArray typedArray) {
        this.isContour = typedArray.hasValue(R.styleable.SupportWidgetFeature_widget_contour_text_color);
        if (isContour) {
            this.mContourColor = ColorStateListWrapper.create(typedArray, 0
                    , R.styleable.SupportWidgetFeature_widget_contour_text_color
                    , R.styleable.SupportWidgetFeature_widget_disabled_contour_text_color
                    , R.styleable.SupportWidgetFeature_widget_pressed_contour_text_color
                    , R.styleable.SupportWidgetFeature_widget_selected_contour_text_color
                    , R.styleable.SupportWidgetFeature_widget_checked_contour_text_color
                    , R.styleable.SupportWidgetFeature_widget_focused_contour_text_color);
            this.mContourWidth = typedArray.getDimension(R.styleable.SupportWidgetFeature_widget_contour_width, this.mContourWidth);
        }
    }

    /**
     * 解析颜色渐变参数.
     */
    private void parseShader(TypedArray typedArray) {
        if (typedArray.hasValue(R.styleable.SupportWidgetFeature_widget_shader_text_colors)) {
            String strColors = typedArray.getString(R.styleable.SupportWidgetFeature_widget_shader_text_colors);

            //#RRGGBB或#AARRGGBB
            if (null == strColors || !strColors.matches("(#([\\da-fA-F]{2}){3,4},)+(#([\\da-fA-F]{2}){3,4})")) {
                throw new IllegalArgumentException("请设置正确的色值");
            }

            String[] strColorArray = strColors.split(",");
            int N = strColorArray.length;
            int[] colors = new int[N];
            for (int i = 0; i < N; i++) {
                colors[i] = Color.parseColor(strColorArray[i]);
            }
            float[] positions = null;
            if (typedArray.hasValue(R.styleable.SupportWidgetFeature_widget_shader_text_positions)) {
                String strPositions = typedArray.getString(R.styleable.SupportWidgetFeature_widget_shader_text_positions);
                //0-0.9 ，>0 <1,0-1
                if (null == strPositions || !strPositions.matches("(0|(0.\\d*)),(0.\\d*,)*(1|(0.\\d*))")) {
                    throw new IllegalArgumentException("请设置正确的色值渐变位置");
                }
                String[] strPositionArray = strPositions.split(",");
                if (strPositionArray.length != N) {
                    throw new IllegalArgumentException("渐变位置个数和色值个数不匹配");
                }
                positions = new float[N];
                for (int i = 0; i < N; i++) {
                    positions[i] = Float.parseFloat(strPositionArray[i]);
                }
            }
            setShader(colors, positions);
        } else if (typedArray.hasValue(R.styleable.SupportWidgetFeature_widget_shader_text_start_color)) {
            int startColor, centerColor, endColor;
            float startPosition, centerPosition, endPosition;

            startColor = WidgetUtils.getColor(typedArray, R.styleable.SupportWidgetFeature_widget_shader_text_start_color, 1);
            centerColor = WidgetUtils.getColor(typedArray, R.styleable.SupportWidgetFeature_widget_shader_text_center_color, 1);
            endColor = WidgetUtils.getColor(typedArray, R.styleable.SupportWidgetFeature_widget_shader_text_end_color, 1);

            startPosition = typedArray.getFloat(R.styleable.SupportWidgetFeature_widget_shader_text_start_position, -1);
            centerPosition = typedArray.getFloat(R.styleable.SupportWidgetFeature_widget_shader_text_center_position, -1);
            endPosition = typedArray.getFloat(R.styleable.SupportWidgetFeature_widget_shader_text_end_position, -1);
            boolean hasPosition;
            if ((hasPosition = (startPosition != -1 || centerPosition != -1 || endPosition != -1))//说明有设置渐变位置.
                    //说明开始色值或开始位置未设置.
                    && ((startColor * startPosition > 0 || ((0 == startColor && -1 == startPosition) || (1 == startColor && 0 == startPosition)))
                    //说明中间色值或中间位置未设置.
                    || (centerColor * centerPosition > 0 || ((0 == centerColor && -1 == centerPosition) || (1 == centerColor && 0 == centerPosition)))
                    //说明结束色值或结束位置未设置.
                    || (endColor * endPosition > 0 || ((0 == endColor && -1 == endPosition) || (1 == endColor && 0 == endPosition))))
            ) {//说明有一项中仅设置了色值或位置.
                throw new IllegalArgumentException("渐变位置个数和色值个数不匹配");
            }
            int N = 3 - (1 == startColor ? 1 : 0) - (1 == centerColor ? 1 : 0) - (1 == endColor ? 1 : 0);
            int[] rawColors = new int[]{startColor, centerColor, endColor};
            float[] rawPositions = new float[]{startPosition, centerPosition, endPosition};
            int[] colors = new int[N];
            float[] positions = new float[N];
            int index = 0;

            for (int i = 0; i < 3; i++) {
                if (rawColors[i] != 1) {
                    colors[index] = rawColors[i];
                    positions[index] = rawPositions[i];
                    index++;
                }
            }
            setShader(colors, hasPosition ? positions : null);
        }
    }

    public boolean isContour() {
        return this.isContour;
    }

    public final void prepareDrawContour() {
        if (!isContour) return;

        TextPaint textPaint = mTarget.getPaint();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setFakeBoldText(true);
        //保存原始数据.
        mSaveTargetWidth = textPaint.getStrokeWidth();
        mSaveTargetColor = mTarget.getTextColors();
        mSaveTargetShader = textPaint.getShader();
        //设置为描边数据.
        textPaint.setStrokeWidth(mContourWidth);
        textPaint.setShader(null);
        mTarget.setTextColor(mContourColor);
    }

    public final void prepareSuperDraw() {
        if (!isContour) return;

        TextPaint textPaint = mTarget.getPaint();
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setFakeBoldText(false);
        //恢复原始数据.
        textPaint.setStrokeWidth(mSaveTargetWidth);
        textPaint.setShader(mSaveTargetShader);
        mTarget.setTextColor(mSaveTargetColor);
    }

    private void setShader() {
        TextPaint textPaint = mTarget.getPaint();
        LinearGradient linearGradient = new LinearGradient(0, 0, mTarget.getMeasuredWidth(), 0
                , mShaderColors, mShaderPosition, Shader.TileMode.CLAMP);
        textPaint.setShader(linearGradient);
        mTarget.invalidate();
    }

    private void invalidate() {
        mTarget.invalidate();
    }

    public final void invalidateShader() {
        if (null != mShaderColors) setShader();
    }

    public TextFeature setContourColor(ColorStateList contourColor) {
        return setContour(mContourWidth, contourColor);
    }

    public TextFeature setContourWidth(float contourWidth) {
        return setContour(mContourWidth, mContourColor);
    }

    public TextFeature setContour(float contourWidth, ColorStateList contourColor) {
        this.mContourWidth = contourWidth;
        this.mContourColor = contourColor;
        invalidate();
        return this;
    }

    public final TextFeature setShader(int[] colors) {
        return setShader(colors, null);
    }

    public final TextFeature setShader(int[] colors, float[] position) {
        this.mShaderColors = colors;
        this.mShaderPosition = position;
        invalidateShader();
        return this;
    }

}
