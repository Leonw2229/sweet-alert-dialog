package cn.madog.sweet.simple;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cn.madog.SweetAlertDialog.SweetAlertDialog;

public class TestActivity extends AppCompatActivity {

    private SweetAlertDialog dialog = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button viewShow = findViewById(R.id.viewShow);
        Button viewChange = findViewById(R.id.viewChange);

        viewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog == null) {
                    dialog = new SweetAlertDialog(TestActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                }

                dialog.setTitleText(SystemClock.currentThreadTimeMillis() + "");
                dialog.changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
                dialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        dialog.changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                        if (!dialog.isShowing()) {
                            dialog.show();
                        }
                    }
                }, 500);
            }
        });


        viewChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}
