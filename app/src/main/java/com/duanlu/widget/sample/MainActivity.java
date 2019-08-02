package com.duanlu.widget.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Checkable;

/********************************
 * @name MainActivity
 * @author 段露
 * @createDate 2019/7/31 18:33
 * @updateDate 2019/7/31 18:33
 * @version V1.0.0
 * @describe 示例.
 ********************************/
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sbtn_selected_sample).setSelected(true);

        findViewById(R.id.tint).setOnClickListener(this);
        findViewById(R.id.tint).setSelected(true);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
    }

    private void enabled(View... views) {
        for (View view : views) {
            view.setEnabled(!view.isEnabled());
        }
    }

    private void selected(View... views) {
        for (View view : views) {
            view.setSelected(!view.isSelected());
        }
    }

    private void checked(View... views) {
        Checkable checkable;
        for (View view : views) {
            if (view instanceof Checkable) {
                checkable = (Checkable) view;
                checkable.setChecked(!checkable.isChecked());
            }
        }
    }

}
