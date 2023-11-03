package com.myutils;

import static com.myutils.ActivityAndContextSet.activity;

import android.app.AlertDialog;

import com.myutils.dialog.SpotsDialog;


public class DialogUtils {

    private static AlertDialog alertDialog;

    private static int dotsCount;
    private static int dotsColor;
    private static int messageColor;
    private static int messageTextSize;
    private static boolean cancelable;
    public static void dialogUtilsParamsSet(int dotsCount1,
                       int dotsColor1,
                       int messageColor1,
                       int messageTextSize1,
                       boolean cancelable1
                       ) {
        dotsCount = dotsCount1;
        dotsColor = dotsColor1;
        messageColor = messageColor1;
        messageTextSize = messageTextSize1;
        cancelable = cancelable1;
    }

    public static void showDialog(String message) {

        alertDialog = new SpotsDialog.Builder().setContext(activity)
                .setDotsCount(dotsCount)
                .setDotsColor(dotsColor)
                .setMessageColor(messageColor)
                .setMessageTextSize(messageTextSize)
                .setCancelable(cancelable)
                .build();
        alertDialog.setMessage(message);
        alertDialog.show();
    }

    public static void showDialogPleaseWait() {

        alertDialog = new SpotsDialog.Builder().setContext(activity)
                .setDotsCount(dotsCount)
                .setDotsColor(dotsColor)
                .setMessageColor(messageColor)
                .setMessageTextSize(messageTextSize)
                .setCancelable(cancelable)
                .setMessage("Please Wait..")
                .build();
        alertDialog.show();
    }

    public static void hideDialog() {
        if (alertDialog != null) {
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
        }
    }

}
