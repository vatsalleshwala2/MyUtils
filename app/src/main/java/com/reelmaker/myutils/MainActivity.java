package com.reelmaker.myutils;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.myutils.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity{
    private static AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button0).setOnClickListener(v -> {
//            DialogUtils.showDialogPleaseWait();

            alertDialog = new SpotsDialog.Builder()
                    .setContext(this)
                    .setDotsCount(7)
                    .setDotsColor(Color.parseColor("#00ff00"))
                    .setMessageColor(Color.parseColor("#FF0000"))
                    .setMessageTextSize(16)
                    .build();
            alertDialog.show();

        });
    }
}