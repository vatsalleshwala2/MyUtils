package com.reelmaker.myutils;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.myutils.ActivityAndContextSet;
import com.myutils.DialogUtils;
import com.myutils.SPUtilsStatic;
import com.myutils.ToastUtils;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ActivityAndContextSet.setContext(getApplicationContext());
        SPUtilsStatic.initSessionManager("My Utils");
        ToastUtils.getInstance().initialize();
        DialogUtils.dialogUtilsParamsSet(5,
                Color.parseColor("#00ff00"),
                Color.parseColor("#FF0000"),
                16,
                Color.WHITE,
                true
        );

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity a, @Nullable Bundle savedInstanceState) {
                ActivityAndContextSet.setActivity(a);
            }

            @Override
            public void onActivityStarted(@NonNull Activity a) {

            }

            @Override
            public void onActivityResumed(@NonNull Activity a) {
                ActivityAndContextSet.setActivity(a);
            }

            @Override
            public void onActivityPaused(@NonNull Activity a) {

            }

            @Override
            public void onActivityStopped(@NonNull Activity a) {

            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity a, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity a) {

            }
        });
    }
}
