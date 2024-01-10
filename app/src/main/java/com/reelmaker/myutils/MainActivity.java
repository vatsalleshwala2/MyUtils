package com.reelmaker.myutils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.myutils.DialogUtils;
import com.myutils.ToastUtils;
import com.myutils.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity{
    private static AlertDialog alertDialog;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button0).setOnClickListener(v -> {
            DialogUtils.showDialogPleaseWait();

//            alertDialog = new SpotsDialog.Builder()
//                    .setContext(this)
//                    .setDotsCount(7)
//                    .setDotsColor(Color.parseColor("#00ff00"))
//                    .setMessageColor(Color.parseColor("#FF0000"))
//                    .setMessageTextSize(16)
//                    .setBgColor(Color.CYAN)
//                    .build();
//            alertDialog.show();

        });
        findViewById(R.id.button1).setOnClickListener(v -> ToastUtils.showToastSuccess("Success"));
        findViewById(R.id.button2).setOnClickListener(v -> ToastUtils.showToastError("Error"));
        findViewById(R.id.button3).setOnClickListener(v -> ToastUtils.showToastInfo("Info"));
        findViewById(R.id.button4).setOnClickListener(v -> ToastUtils.showToastWarning("Warning"));
    }
}