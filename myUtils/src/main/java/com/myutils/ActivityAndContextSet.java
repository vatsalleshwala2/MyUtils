package com.myutils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

@SuppressLint("StaticFieldLeak")
public class ActivityAndContextSet {

    public static Activity activity;
    public static Context context;

    public static void setActivity(Activity activity1) {
        activity = activity1;
    }

    public static void setContext(Context context1) {
        context = context1;
    }
}
