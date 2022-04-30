package com.dt.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dt.sweetdialog.SweetDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn_1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SweetDialog dialog = new SweetDialog(MainActivity.this);
                dialog.setTitleInfo("title");
                dialog.setMessageInfo("qqqqqqqqqqqqqqqqqqqqqqqqqqq");
                dialog.setPositiveButton("是", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                dialog.setNegativeButton("否", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                dialog.show();
            }
        });
    }
}