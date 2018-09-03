package cn.madog.sweet.simple;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import cn.madog.SweetAlertDialog.SweetAlertDialog;

public class TestActivity extends Activity {

    private SweetAlertDialog dialog = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button viewShow = findViewById(R.id.viewShow);

        viewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog == null) {
                    dialog = new SweetAlertDialog(TestActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                }

                dialog.setTitleText(SystemClock.currentThreadTimeMillis() + "");
                dialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
                dialog.show();

                dialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                dialog.show();
            }
        });
    }
}
