package com.dt.sweetdialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SweetDialog extends Dialog {
    private TextView tv_title;
    private TextView tv_content;
    private TextView btn_yes;
    private TextView btn_no;
    private View hor_view;
    private View ver_view;
    private LinearLayout btn_group;

    private String str_title;
    private String str_content;
    private String str_yes;
    private String str_no;
    private boolean enable_cancel_outside = false;
    private View.OnClickListener yesClick;
    private View.OnClickListener noClick;

    public SweetDialog(Context context) {
        super(context, R.style.theme_sweet_dialog);
        getWindow().setWindowAnimations(R.style.anim_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        tv_title = findViewById(R.id.dialog_title);
        tv_content = findViewById(R.id.dialog_content);
        btn_yes = findViewById(R.id.btn_yes);
        btn_no = findViewById(R.id.btn_no);
        btn_group = findViewById(R.id.button_group);

        hor_view = findViewById(R.id.splite_horizontal);
        ver_view = findViewById(R.id.splite_vertical);

        setTitleInfo(str_title);
        setMessageInfo(str_content);
        setPositiveButton(str_yes, yesClick);
        setNegativeButton(str_no, noClick);
        setCanceledOnTouchOutside(enable_cancel_outside);
    }

    public SweetDialog setTitleInfo(String title){
        str_title = title;

        if(tv_title != null){
            if(title == null || title.trim().length() == 0){
                tv_title.setVisibility(View.GONE);
            }else {
                tv_title.setVisibility(View.VISIBLE);
                tv_title.setText(title);
            }
        }
        return this;
    }

    public SweetDialog setMessageInfo(String info){
        str_content = info;

        if(tv_content != null)
            tv_content.setText(info);
        return this;
    }

    public SweetDialog setPositiveButton(String name, View.OnClickListener callback){
        str_yes = name;
        yesClick = callback;

        if(btn_yes != null){
            if(name == null || name.trim().length() == 0){
                btn_yes.setVisibility(View.GONE);
            }
            else {
                btn_yes.setVisibility(View.VISIBLE);
                btn_yes.setText(name);
                if(callback != null)
                    btn_yes.setOnClickListener(callback);
            }
        }
        refreshSpliteView();
        return this;
    }

    public SweetDialog setNegativeButton(String name, View.OnClickListener callback){
        str_no = name;
        noClick = callback;

        if(btn_no != null){
            if(name == null || name.trim().length() == 0){
                btn_no.setVisibility(View.GONE);
            }
            else{
                btn_no.setVisibility(View.VISIBLE);
                btn_no.setText(name);
                if(callback != null)
                    btn_no.setOnClickListener(callback);
            }
        }
        refreshSpliteView();
        return this;
    }

    public SweetDialog setCancelOnTouchOutside(boolean enable){
        enable_cancel_outside = enable;

        return this;
    }

    private void refreshSpliteView(){
        if(btn_yes != null && btn_no != null){
            boolean visiable_yes = btn_yes.getVisibility() == View.VISIBLE;
            boolean visiable_no = btn_no.getVisibility() == View.VISIBLE;
            hor_view.setVisibility((visiable_yes || visiable_no) ? View.VISIBLE : View.GONE);
            ver_view.setVisibility((visiable_yes && visiable_no) ? View.VISIBLE : View.GONE);
            btn_group.setVisibility(hor_view.getVisibility());
            if(hor_view.getVisibility() == View.GONE)
                setCancelOnTouchOutside(true);
        }
    }
}
