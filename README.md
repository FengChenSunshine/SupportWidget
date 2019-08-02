# SupportWidget 一个简单且够用的Android控件扩展selector、shape标签等功能UI库.

[![](https://www.jitpack.io/v/FengChenSunshine/SupportWidget.svg)](https://www.jitpack.io/#FengChenSunshine/SupportWidget)
[![](https://img.shields.io/badge/Apache-2.0-brightgreen.svg)](https://github.com/FengChenSunshine/SupportWidget/blob/master/LICENSE)

## 一、初衷
网上关于扩展shape、实现selector功能的库很多，但是大多存在过渡封装，使其变得臃肿，变得不再各司其职，违背指责单一原则。
比如一个TextView实现下载图片功能，那还需要ImageView做什么？TextView实现按钮功能，那还需要Button做什么？……等等？
不是说这样不好，只是在很多时候这些过渡封装实现的功能显得有点鸡肋。
>**_所以，本库的初衷就是追求：简单且够用！！！_**

## 二、部分功能效果如下，可自由搭配实现更新更多效果：
<img src="https://github.com/FengChenSunshine/SupportWidget/blob/master/app/src/main/res/drawable/sample_1.jpg" width="360"><img src="https://github.com/FengChenSunshine/SupportWidget/blob/master/app/src/main/res/drawable/sample_2.jpg" width="360">

## 三、优点
1.轻量：简单且够用！！！

2.功能强大：几乎包含drawable-shape标签下所有属性，包含drawable-selector标签下disable、pressed、selected、focused、default选择器状态。

3.覆盖面广：实现了TextView、EditText、Button、ImageView、CheckBox、LinearLayout等等常用控件扩展功能。

4.特殊功能：实现文字描边、渐变、着色、旋转等功能。

5.使用简单：告别总是需要在drawable中定义选择器的烦恼，xml中轻松配置。

6.智能规范：xml布局中属性智能提示，命名规范不需要记忆大量属性名称。

7.各司其职：职责单一，需要什么功能用什么控件。

8.扩展简单：可根据需要只需要几行代码就能移植该库实现功能到自定义View或者本库未提供的系统View中。

## 四、目前该库包含的控件分为4以下类
[SupportTextView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportTextView.java (SupportTextView)
[SupportAutoCompleteTextView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportAutoCompleteTextView.java (SupportAutoCompleteTextView)
[SupportMultiAutoCompleteTextView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportMultiAutoCompleteTextView.java (SupportMultiAutoCompleteTextView)
[SupportButton]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportButton.java (SupportButton)
[SupportEditText]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportEditText.java (SupportEditText)
[SupportCheckBox]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportCheckBox.java (SupportCheckBox)
[SupportRadioButton]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportRadioButton.java (SupportRadioButton)
[SupportImageView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportImageView.java (SupportImageView)
[SupportImageButton]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportImageButton.java (SupportImageButton)
[SupportLinearLayout]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportLinearLayout.java (SupportLinearLayout)
[SupportFrameLayout]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportFrameLayout.java (SupportFrameLayout)
[SupportRelativeLayout]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportRelativeLayout.java (SupportRelativeLayout)
[SupportRadioGroup]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportRadioGroup.java (SupportRadioGroup)
[SupportSearchView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportSearchView.java (SupportSearchView)
[SupportFeatureTextView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportFeatureTextView.java (SupportFeatureTextView)
[SupportFeatureButton]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportFeatureButton.java (SupportFeatureButton)
[SupportFeatureImageView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportFeatureImageView.java (SupportFeatureImageView)
[SupportView]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportView.java (SupportView)
[SupportViewGroup]: https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/java/com/duanlu/widget/SupportViewGroup.java (SupportViewGroup)

### 1.View子类、TextView及其子类扩展类，该类控件实现了shape标签和选择器功能：
| 控件 | 父类 | shape标签 | selector标签 | 文字描边(支持各状态)、渐变等 | 图片着色(支持各状态)、旋转等 |
| :-: | :-: | :-: | :-: | :-: | :-: |
| [SupportTextView] | AppCompatTextView(TextView) | √ | √ | - | - |
| [SupportAutoCompleteTextView] | AppCompatAutoCompleteTextView<br/>(AutoCompleteTextView)| √ | √ | - | - |
| [SupportMultiAutoCompleteTextView] | AppCompatMultiAutoCompleteTextView<br/>(MultiAutoCompleteTextView) | √ | √ | - | - |
| [SupportButton] | AppCompatButton(Button) | √ | √ | - | - |
| [SupportEditText] | AppCompatEditText(EditText) | √ | √ | - | - |
| [SupportCheckBox] | AppCompatCheckBox(CheckBox) | √ | √ | - | - |
| [SupportRadioButton] | AppCompatRadioButton(RadioButton) | √ | √ | - | - |
| [SupportImageView] | AppCompatImageView(ImageView) | √ | √ | - | - |
| [SupportImageButton] | AppCompatImageButton(ImageButton) | √ | √ | - | - |

### 2.ViewGroup子类扩展类，该类控件实现了shape标签和选择器功能：
| 控件 | 父类 | shape标签 | selector标签 | 文字描边(支持各状态)、渐变等 | 图片着色(支持各状态)、旋转等 |
| :-: | :-: | :-: | :-: | :-: | :-: |
| [SupportLinearLayout] | LinearLayout | √ | √ | - | - |
| [SupportFrameLayout] | FrameLayout | √ | √ | - | - |
| [SupportRelativeLayout] | RelativeLayout | √ | √ | - | - |
| [SupportRadioGroup] | RadioGroup | √ | √ | - | - |
| [SupportSearchView] | SearchView | √ | √ | - | - |

### 3.特殊功能(描边、着色等)扩展类，该类控件在第一类基础上扩展了一些特殊功能：
| 控件 | 父类 | shape标签 | selector标签 | 文字描边(支持各状态)、渐变等 | 图片着色(支持各状态)、旋转等 |
| :-: | :-: | :-: | :-: | :-: | :-: |
| [SupportFeatureTextView] | SupportTextView | √ | √ | √ | - |
| [SupportFeatureButton] | SupportButton | √ | √ | √ | - |
| [SupportFeatureImageView] | SupportImageView | √ | √ | - | √ |

### 4.用户自定义扩展类，该类控件主要用来提供给需要在自定义控件中实现以上功能时使用：
| 控件 | 父类 | shape标签 | selector标签 | 文字描边(支持各状态)、渐变等 | 图片着色(支持各状态)、旋转等 |
| :-: | :-: | :-: | :-: | :-: | :-: |
| [SupportView] | View | √ | √ | - | - |
| [SupportViewGroup] | ViewGroup | √ | √ | - | - |

## 五、使用步骤
### 1.添加依赖
**step one：**

    allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
	    }
    }
  
**step two ：**

    dependencies {
            implementation 'com.github.FengChenSunshine:SupportWidget:1.0.0'
    }
                
## 六、属性
### 1.默认状态属性:
| 属性 | 对应标签 | 描述 | 值 | 备注 |
| :-: | :-: |  :-: |  :-: |  :-: | 
| widget_shape | shape标签<br/>->shape属性 |  | 可选值:<br/>rectangle<br/>oval<br/>line<br/>ring |  |
| widget_size_width | shape标签<br/>->size标签<br/>->width属性 |  | dimension |  |
| widget_size_height | shape标签<br/>->size标签<br/>->height属性 |  | dimension |  |
| widget_padding_left | shape标签<br/>->padding标签<br/>->left属性 |  | dimension |  |
| widget_padding_top | shape标签<br/>->padding标签<br/>->top属性 |  | dimension |  |
| widget_padding_right | shape标签<br/>->padding标签<br/>->right属性 |  | dimension |  |
| widget_padding_bottom | shape标签<br/>->padding标签<br/>->bottom属性 |  | dimension |  |
| widget_corners_radius | shape标签<br/>->corners标签<br/>->radius属性 | 全部的圆角半径 | dimension | 会被下面其它对应值覆盖 |
| widget_corners_top_left_radius | shape标签<br/>->corners标签<br/>->topLeftRadius属性 | 左上角的圆角半径 | dimension |  |
| widget_corners_top_right_radius | shape标签<br/>->corners标签<br/>->topRightRadius属性 | 右上角的圆角半径 | dimension |  |
| widget_corners_bottom_left_radius | shape标签<br/>->corners标签<br/>->bottomLeftRadius属性 | 左下角的圆角半径 | dimension |  |
| widget_corners_bottom_right_radius | shape标签<br/>->corners标签<br/>->bottomRightRadius属性 | 右下角的圆角半径 | dimension |  |
| widget_stroke_color | shape标签<br/>->stroke标签<br/>->color属性 | 描边的颜色 | color |  |
| widget_stroke_width | shape标签<br/>->stroke标签<br/>->width属性 | 描边的宽度 | dimension |  |
| widget_stroke_dash_width | shape标签<br/>->stroke标签<br/>->dashWidth属性 | 虚线的宽度 | dimension | 值为0时是实线 |
| widget_stroke_dash_gap | shape标签<br/>->stroke标签<br/>->dashGap属性 | 虚线的间隔 | dimension |  |
| widget_solid | shape标签<br/>->solid标签<br/>->color属性 | 内部填充色 | color |  |
| widget_gradient_start_color | shape标签<br/>->gradient标签<br/>->startColor属性 | 渐变开始点的颜色 | color |  |
| widget_gradient_center_color | shape标签<br/>->gradient标签<br/>->centerColor属性 | 渐变中间点的颜色 | color | 在开始与结束点之间 |
| widget_gradient_end_color | shape标签<br/>->gradient标签<br/>->endColor属性 | 渐变结束点的颜色 | color |  |
| widget_gradient_angle | shape标签<br/>->gradient标签<br/>->angle属性 | 渐变角度 | 可选值:<br/>left_right<br/>bl_tr<br/>bottom_top<br/>br_tl<br/>right_left<br/>tr_bl<br/>top_bottom<br/>tl_br | 仅在widget_gradient_type=<br/>"integer"时有效,且必须为45的倍数,<br/>0为从左到右,90为从上到下.<br/>这里使用枚举代替原生的数值方式 |
| widget_gradient_center_x | shape标签<br/>->gradient标签<br/>->centerX属性 | 渐变中心X的相当位置 | float、fraction | 范围为0.0～1.0,仅在widget_gradient_type属性不为linear时有效 |
| widget_gradient_center_y | shape标签<br/>->gradient标签<br/>->centerY属性 | 渐变中心Y的相当位置 | float、fraction | 范围为0.0～1.0,仅在widget_gradient_type属性不为linear时有效 |
| widget_gradient_radius | shape标签<br/>->gradient标签<br/>->gradientRadius属性 | 渐变的半径 | dimension | 只有当渐变类型为radial时才能使用 |
| widget_gradient_type | shape标签<br/>->gradient标签<br/>->type属性 | 渐变模式 | 可选值:<br/>linear<br/>radial<br/>sweep | 线性渐变、放射性渐变、扫描式渐变 |
| widget_gradient_use_level | shape标签<br/>->gradient标签<br/>->useLevel属性 | useLevel属性通常不使用 | boolean | 该属性用于指定是否将该shape<br/>当成一个LevelListDrawable来使用，默认值为false |
| widget_ripple_color | ripple标签<br/>->color属性 | 水波纹效果颜色 | color | 5.0以上默认开启,<br/>未设置时首先会尝试获取<br/>android.support.v7.appcompat.<br/>R.attr.colorControlHighlight属性值;<br/>获取失败时使用默认值#1f000000,<br/>该值取自v7 28.0.0版本Base.ThemeOverlay.AppCompat.Light主题下colorControlHighlight属性值 |
| widget_ripple_enabled |  | 水波纹效果控制开关 | boolean | 5.0以上默认开启水波纹效果,<br/>但是可以通过设置此值为false可以关闭该默认效果 |
| widget_text_color | - | TextView等文本控件Text文字颜色 | color |  |
| widget_hint_text_color |  | TextView等文本控件Hint文字颜色 | color |  |
### 2.disable禁用状态属性:
   disable状态拥有上面属性1中默认状态下除过水波纹以外的所有属性，
   命名规则为将以上widget_修改为widget_disabled_格式，含义等其它信息均保持不变。
   具体有如下属性：
 
        <attr name="widget_disabled_shape"/>
        <attr name="widget_disabled_size_width"/>
        <attr name="widget_disabled_size_height"/>
        <attr name="widget_disabled_padding_left"/>
        <attr name="widget_disabled_padding_top"/>
        <attr name="widget_disabled_padding_right"/>
        <attr name="widget_disabled_padding_bottom"/>
        <attr name="widget_disabled_corners_radius"/>
        <attr name="widget_disabled_corners_top_left_radius"/>
        <attr name="widget_disabled_corners_top_right_radius"/>
        <attr name="widget_disabled_corners_bottom_left_radius"/>
        <attr name="widget_disabled_corners_bottom_right_radius"/>
        <attr name="widget_disabled_stroke_color"/>
        <attr name="widget_disabled_stroke_width"/>
        <attr name="widget_disabled_stroke_dash_width"/>
        <attr name="widget_disabled_stroke_dash_gap"/>
        <attr name="widget_disabled_solid"/>
        <attr name="widget_disabled_gradient_start_color"/>
        <attr name="widget_disabled_gradient_center_color"/>
        <attr name="widget_disabled_gradient_end_color"/>
        <attr name="widget_disabled_gradient_angle"/>
        <attr name="widget_disabled_gradient_center_x"/>
        <attr name="widget_disabled_gradient_center_y"/>
        <attr name="widget_disabled_gradient_radius"/>
        <attr name="widget_disabled_gradient_type"/>
        <attr name="widget_disabled_gradient_use_level"/>
        <attr name="widget_disabled_text_color"/>
        <attr name="widget_disabled_hint_text_color"/>
### 3.pressed触摸按压状态属性:
   pressed状态拥有上面属性1中默认状态下除过水波纹以外的所有属性，
   命名规则为将以上widget_修改为widget_pressed_格式，含义等其它信息均保持不变。
   eg：
   
    <attr name="widget_pressed_text_color"/>
   其它同上，不再赘述。
### 4.selected选中状态属性:
   selected状态拥有上面属性1中默认状态下除过水波纹以外的所有属性，
   命名规则为将以上widget_修改为widget_selected_格式，含义等其它信息均保持不变。
   eg：
   
    <attr name="widget_selected_text_color"/>
   其它同上，不再赘述。
### 5.focused获得焦点状态属性:
   focused状态拥有上面属性1中默认状态下除过水波纹以外的所有属性，
   命名规则为将以上widget_修改为widget_focused_格式，含义等其它信息均保持不变。
   eg：

    <attr name="widget_focused_text_color"/>
   其它同上，不再赘述。
### 6.文字描边效果属性:
| 属性 | 对应标签 | 描述 | 值 | 备注 |
| :-: | :-: |  :-: |  :-: |  :-: | 
| widget_contour_width |  | 描边宽度 | dimension |  |
| widget_contour_text_color |  | 默认状态下描边颜色 | color |  |
| widget_checked_contour_text_color |  | checked状态下描边颜色 | color |  |
| widget_disabled_contour_text_color |  | disabled状态下描边颜色 | color |  |
| widget_focused_contour_text_color |  | focused状态下描边颜色 | color |  |
| widget_pressed_contour_text_color |  | pressed状态下描边颜色 | color |  |
| widget_selected_contour_text_color |  | selected状态下描边颜色 | color |  |
### 7.文字颜色渐变效果属性:
| 属性 | 对应标签 | 描述 | 值 | 备注 |
| :-: | :-: |  :-: |  :-: |  :-: | 
| widget_shader_text_start_color |  | 渐变开始颜色 | color |  |
| widget_shader_text_center_color |  | 渐变中间颜色 | color |  |
| widget_shader_text_end_color |  | 渐变结束颜色 | color |  |
| widget_shader_text_start_position |  | 渐变开始位置颜色偏移 | float | 不设置时为线性渐变 |
| widget_shader_text_center_position |  | 渐变中间位置颜色偏移 | float | 不设置时为线性渐变 |
| widget_shader_text_end_position |  | 渐变结束位置颜色偏移 | float | 不设置时为线性渐变 |
| widget_shader_text_colors |  | 渐变颜色 | string | 格式:#RRGGBB,#RRGGBB,……#RRGGBB<br/>或#AARRGGBB,#AARRGGBB,……#AARRGGBB |
| widget_shader_text_positions |  | 渐变位置颜色偏移 | string | 范围：0.0-1.0<br/>格式:float,float,……float<br/>简单校验:第一个值必须小于1，<br/>最后一个值必须大于0<br/>如果设置了该属性，<br/>那么个数必须和widget_shader_text_colors匹配.<br/>不设置时为线性渐变. |
### 8.图片Tint(着色)、旋转效果属性:
| 属性 | 对应标签 | 描述 | 值 | 备注 |
| :-: | :-: |  :-: |  :-: |  :-: | 
| widget_src_tint |  | 默认状态下tint颜色 | color |  |
| widget_checked_src_tint |  | checked状态下tint颜色 | color |  |
| widget_disabled_src_tint |  | disabled状态下tint颜色 | color |  |
| widget_focused_src_tint |  | focused状态下tint颜色 | color |  |
| widget_pressed_src_tint |  | pressed状态下tint颜色 | color |  |
| widget_selected_src_tint |  | selected状态下tint颜色 | color |  |
| widget_src_rotate_degrees |  | 图片旋转角度 | float、fraction | 系统rotation属性会导致View整体旋转<br/>使用该属性可以实现仅旋转图片<br/>该功能和tint搭配使用可以有效减小APK体积 |

## 七、选择器效果实现、完整用法示例
将之前的属性描述中的1到5部分的默认状态、disable禁用状态、pressed触摸按压状态、selected选中状态、focused获得焦点状态搭配结合使用即可获得选择器效果。
### 1.背景选择器eg:
    <com.duanlu.widget.SupportLinearLayout
                 android:layout_width="20dp"
                 android:layout_height="20dp"
                 
                 <!--默认状态-->
                 
                 app:widget_corners_radius="8dp"
                 app:widget_corners_bottom_left_radius="8dp"
                 app:widget_corners_bottom_right_radius="8dp"
                 app:widget_corners_top_left_radius="8dp"
                 app:widget_corners_top_right_radius="8dp"
     
                 app:widget_gradient_start_color="#0000ff"
                 app:widget_gradient_center_color="#00ff00"
                 app:widget_gradient_end_color="#ff0000"
                 app:widget_gradient_center_x="0.5"
                 app:widget_gradient_center_y="0.5"
                 app:widget_gradient_type="linear"
                 app:widget_gradient_radius="50dp"
                 app:widget_gradient_angle="left_right"
                 app:widget_gradient_use_level="false"
     
                 app:widget_solid="#008577"
     
                 app:widget_stroke_color="#000000"
                 app:widget_stroke_dash_gap="5dp"
                 app:widget_stroke_dash_width="5dp"
                 app:widget_stroke_width="2dp"
     
                 <!--disabled状态-->
                 
                 app:widget_disabled_corners_radius="8dp"
                 app:widget_disabled_corners_bottom_left_radius="8dp"
                 app:widget_disabled_corners_bottom_right_radius="8dp"
                 app:widget_disabled_corners_top_left_radius="8dp"
                 app:widget_disabled_corners_top_right_radius="8dp"
     
                 app:widget_disabled_gradient_start_color="#0000ff"
                 app:widget_disabled_gradient_center_color="#00ff00"
                 app:widget_disabled_gradient_end_color="#ff0000"
                 app:widget_disabled_gradient_center_x="0.5"
                 app:widget_disabled_gradient_center_y="0.5"
                 app:widget_disabled_gradient_type="linear"
                 app:widget_disabled_gradient_radius="50dp"
                 app:widget_disabled_gradient_angle="left_right"
                 app:widget_disabled_gradient_use_level="false"
     
                 app:widget_disabled_solid="#008577"
     
                 app:widget_disabled_stroke_color="#000000"
                 app:widget_disabled_stroke_dash_gap="5dp"
                 app:widget_disabled_stroke_dash_width="5dp"
                 app:widget_disabled_stroke_width="2dp"
     
                 <!--pressed状态-->
                 
                 app:widget_pressed_corners_radius="8dp"
                 app:widget_pressed_corners_bottom_left_radius="8dp"
                 app:widget_pressed_corners_bottom_right_radius="8dp"
                 app:widget_pressed_corners_top_left_radius="8dp"
                 app:widget_pressed_corners_top_right_radius="8dp"
     
                 app:widget_pressed_gradient_start_color="#0000ff"
                 app:widget_pressed_gradient_center_color="#00ff00"
                 app:widget_pressed_gradient_end_color="#ff0000"
                 app:widget_pressed_gradient_center_x="0.5"
                 app:widget_pressed_gradient_center_y="0.5"
                 app:widget_pressed_gradient_type="linear"
                 app:widget_pressed_gradient_radius="50dp"
                 app:widget_pressed_gradient_angle="left_right"
                 app:widget_pressed_gradient_use_level="false"
     
                 app:widget_pressed_solid="#008577"
     
                 app:widget_pressed_stroke_color="#000000"
                 app:widget_pressed_stroke_dash_gap="5dp"
                 app:widget_pressed_stroke_dash_width="5dp"
                 app:widget_pressed_stroke_width="2dp"
     
                 <!--selected状态-->
                 
                 app:widget_selected_corners_radius="8dp"
                 app:widget_selected_corners_bottom_left_radius="8dp"
                 app:widget_selected_corners_bottom_right_radius="8dp"
                 app:widget_selected_corners_top_left_radius="8dp"
                 app:widget_selected_corners_top_right_radius="8dp"
     
                 app:widget_selected_gradient_start_color="#0000ff"
                 app:widget_selected_gradient_center_color="#00ff00"
                 app:widget_selected_gradient_end_color="#ff0000"
                 app:widget_selected_gradient_center_x="0.5"
                 app:widget_selected_gradient_center_y="0.5"
                 app:widget_selected_gradient_type="linear"
                 app:widget_selected_gradient_radius="50dp"
                 app:widget_selected_gradient_angle="left_right"
                 app:widget_selected_gradient_use_level="false"
     
                 app:widget_selected_solid="#008577"
     
                 app:widget_selected_stroke_color="#000000"
                 app:widget_selected_stroke_dash_gap="5dp"
                 app:widget_selected_stroke_dash_width="5dp"
                 app:widget_selected_stroke_width="2dp"
     
                 <!--focused状态-->
                 
                 app:widget_focused_corners_radius="8dp"
                 app:widget_focused_corners_bottom_left_radius="8dp"
                 app:widget_focused_corners_bottom_right_radius="8dp"
                 app:widget_focused_corners_top_left_radius="8dp"
                 app:widget_focused_corners_top_right_radius="8dp"
     
                 app:widget_focused_gradient_start_color="#0000ff"
                 app:widget_focused_gradient_center_color="#00ff00"
                 app:widget_focused_gradient_end_color="#ff0000"
                 app:widget_focused_gradient_center_x="0.5"
                 app:widget_focused_gradient_center_y="0.5"
                 app:widget_focused_gradient_type="linear"
                 app:widget_focused_gradient_radius="50dp"
                 app:widget_focused_gradient_angle="left_right"
                 app:widget_focused_gradient_use_level="false"
     
                 app:widget_focused_solid="#008577"
     
                 app:widget_focused_stroke_color="#000000"
                 app:widget_focused_stroke_dash_gap="5dp"
                 app:widget_focused_stroke_dash_width="5dp"
                 app:widget_focused_stroke_width="2dp"/>
### 2.文本选择器eg:
     <com.duanlu.widget.SupportTextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
    
                app:widget_text_color="#333333"
                app:widget_disabled_text_color="#333333"
                app:widget_pressed_text_color="#333333"
                app:widget_selected_text_color="#333333"
                app:widget_checked_text_color="#333333"
                app:widget_focused_text_color="#333333"
    
                app:widget_hint_text_color="#333333"
                app:widget_disabled_hint_text_color="#333333"
                app:widget_pressed_hint_text_color="#333333"
                app:widget_selected_hint_text_color="#333333"
                app:widget_checked_hint_text_color="#333333"
                app:widget_focused_hint_text_color="#333333"/>
### 3.描边选择器、渐变文字eg:
    <com.duanlu.widget.SupportFeatureTextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="48sp"
    
                app:widget_contour_width="5dp"
                app:widget_contour_text_color="#008577"
                app:widget_checked_contour_text_color="#008577"
                app:widget_disabled_contour_text_color="#008577"
                app:widget_pressed_contour_text_color="#008577"
                app:widget_focused_contour_text_color="#008577"
                app:widget_selected_contour_text_color="#008577"
    
                app:widget_shader_text_start_color="#ff0000"
                app:widget_shader_text_center_color="#00ff00"
                app:widget_shader_text_end_color="#0000ff"
                app:widget_shader_text_start_position="0.1"
                app:widget_shader_text_center_position="#0.5"
                app:widget_shader_text_end_position="0.9"
                <!--或者-->
                app:widget_shader_text_colors="#ff0000,#00ff00,#0000ff"
                app:widget_shader_text_positions="0.1,0.5,0.9"/>
### 4.图片着色、旋转eg:
    <com.duanlu.widget.SupportFeatureImageView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
    
                <!--仅旋转图片-->
                android:rotation="30"
                <!--着色-->
                app:widget_src_tint="#008577"
                app:widget_disabled_src_tint="#008577"
                app:widget_pressed_src_tint="#008577"
                app:widget_selected_src_tint="#008577"
                app:widget_checked_src_tint="#008577"
                app:widget_focused_src_tint="#008577"/>
### 5.自定义View中集成该库功能eg:
#### ①选择直接继承SupportView或SupportViewGroup即可实现自己的背景选择器功能。
#### ②选择继承SupportTextView等即可实现自己的背景选择器、文本颜色选择器功能。
#### ③选择继承SupportFeatureTextView等类型即可实现自己的背景选择器、文本颜色选择器以及文本描边和渐变或图片着色、旋转灯功能。
#### ④如果没有继承本库提供的控件但是想实现本库的功能，可以参考如下方式自行实现：
    public class CustomView extends View {
    
        public CustomView(Context context) {
            this(context, null);
        }
    
        public CustomView(Context context, @Nullable AttributeSet attrs) {
            this(context, attrs, 0);
        }
    
        public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            this.initView(context, attrs, defStyleAttr, 0);
        }
    
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            this.initView(context, attrs, defStyleAttr, defStyleRes);
        }
    
        private void initView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            //实现背景选择器功能.
            new WidgetDrawableWrapper(this, attrs, defStyleAttr, defStyleRes);
            //实现文本颜色选择器功能(注意：第一个参数必须是TextView的子类).
            new WidgetTextWrapper(this, attrs, defStyleAttr, defStyleRes);
            //实现文本描边、渐变等功能(注意：第一个参数必须是TextView的子类).
            new TextFeature(this, attrs, defStyleAttr, defStyleRes);
            //实现图片着色、旋转灯等功能(注意：第一个参数必须是AppCompatImageView的子类).
            new ImageFeature(this, attrs, defStyleAttr, defStyleRes);
        }
    }
注意：如果想在自己自定义的View在xml中拥有IDE代码提示功能，那么你需要在res->values->attrs中以自定义View名字定义一个属性即可，eg：
    
    <declare-styleable name="CustomView">
            <attr name="widget_corners_radius" />
            <attr name="widget_corners_top_left_radius" />
            <attr name="widget_corners_top_right_radius" />
            <attr name="widget_corners_bottom_left_radius" />
            <attr name="widget_corners_bottom_right_radius" />
            <attr name="widget_stroke_color" />
            <attr name="widget_stroke_width" />
            <attr name="widget_stroke_dash_width" />
            <attr name="widget_stroke_dash_gap" />
            <attr name="widget_solid" />
            ……<!--其它属性-->
        </declare-styleable>

[attrs]:https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/res/values/attrs.xml (attrs)
[attrs_feature]:https://github.com/FengChenSunshine/SupportWidget/blob/master/library_widget/src/main/res/values/attrs_feature.xml (attrs_feature)
这里仅列举了部分属性，自己需要根据实际情况添加属性即可，但是属性名称必须参考该库命名且必须保持命名一致。
具体可以复制[attrs]和[attrs_feature]里的需要的属性到自己定义的文件里。

## 八、动态修改
原则上本库不提倡使用Java代码动态修改设置，建议使用xml中配置的方式设置。
但是如果真的有动态修改的需求，那么以SupportFeatureTextView为例，其它控件方法相同，可以通过以下方式动态修改：
### 1.修改背景色选择器相关:
    SupportFeatureTextView view;
        view.getWidgetDrawableWrapper()
            .setRippleColor(@ColorInt int color)
            .setRippleColor(ColorStateList color)
            .setSize(@Status int status, int width, int height)
            .setCorners(@Status int status, float radius)
            .setCorners(@Status int status, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius)
            .setStroke(@Status int status, int strokeWidth, @ColorInt int strokeColor)
            .setStroke(@Status int status, int strokeWidth, @NonNull ColorStateList strokeColor)
            .setStroke(@Status int status, int strokeWidth, @ColorInt int strokeColor, int strokeDashWidth, int strokeDashGap)
            .setStroke(@Status int status, int strokeWidth, @NonNull ColorStateList strokeColor, int strokeDashWidth, int strokeDashGap)
            .setSolidColor(@Status int status, @ColorInt int color)
            .setSolidColor(@Status int status, @NonNull ColorStateList colorStateList)
            .setColors(@Status int status, int startColor, int endColor)
            .setColors(@Status int status, int startColor, int centerColor, int endColor)
            .setGradientCenter(@Status int status, float x, float y)
            .setGradientType(@Status int status, int gradientType)
            .setOrientation(@Status int status, GradientDrawable.Orientation orientation)
            .setGradientRadius(@Status int status, float gradientRadius)
            .setUseLevel(@Status int status, boolean useLevel)
### 2.修改文字选择器颜色相关:
不提供，可通过TextView及其子类中原生方法：
textView.setTextColor(colorStateList);
textView.setHintTextColor(colorStateList);修改。
### 3.文字描边、文字渐变相关:
    SupportFeatureTextView view;
        view.getTextFeature()
            .setContourColor(ColorStateList contourColor)
            .setContourWidth(float contourWidth)
            .setContour(float contourWidth, ColorStateList contourColor)
            .setShader(int[] colors)
            .setShader(int[] colors, float[] position);
### 4.ImageView旋转图片相关:
    SupportFeatureImageView view;
        view.getImageFeature()
            .setRotateDegrees(float rotateDegrees);
## 九、Q&A
### Q1.为什么仅设置背景选择器中某一状态的一个属性会导致比如默认状态为圆角，选中状态为直角了？
    A:遵从在drawable-selector中定义shape一样，每种状态样式单独定义。
### Q2.为什么比如设置了文本颜色选择器获取焦点时的颜色但是没有效果？
    A:使用文本颜色选择器时必须使用widget_text_color或widget_hint_text_color属性设置默认颜色其它状态颜色才会有效。
### Q3.为什么比如设置了描边颜色选择器获取焦点时的描边颜色但是没有效果？
    A:使用描边颜色选择器时必须使用widget_contour_text_color属性设置默认描边颜色其它状态颜色才会有效。
### Q4.为什么比如使用widget_shader_text_start_color属性设置了文本颜色渐变但是没有效果？
    A:文本颜色渐变效果必须设置2个以上颜色时才会有效，并且如果有设置position时，position和color必须匹配，否则可能会导致程序崩溃。
## 十、版本说明
### 1.0.0
1.提供常用的基于selector、shape的背景选择器功能；

2.提供基于ColorStateList的颜色选择器功能；

3.提供文本描边、渐变功能；

4.提供ImageView图片着色、旋转功能。

5.开放自定义控件实现该库功能的能力。
## 十一、[9.点击查看简书上使用方法介绍](https://www.jianshu.com/p/895c9441c28b)
## 十二.最后，喜欢的话可以点个赞哦！！！
## 十三.我的开源库链接
   1.[![](https://img.shields.io/badge/UiStatus-1.0.3-brightgreen.svg)](https://github.com/FengChenSunshine/UiStatus)是我的另一个开源库：一个简单且强大的Ui状态视图控制库！喜欢的可以看看，欢迎start！！！
   
   2.[![](https://img.shields.io/badge/SupportWidget-1.0.0-brightgreen.svg)](https://github.com/FengChenSunshine/SupportWidget)是我的另一个开源库：一个追求简单够用且强大的UI组件库！喜欢的可以看看，欢迎start！！！
   
   3.[![](https://img.shields.io/badge/VersionUpdate-1.0.4-brightgreen.svg)](https://github.com/FengChenSunshine/VersionUpdate)是我的另一个开源库：提供一个应用版本更新功能的库！喜欢的可以看看，欢迎start！！！
    
