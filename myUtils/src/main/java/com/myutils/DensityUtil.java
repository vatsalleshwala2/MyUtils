package com.myutils;

import static com.myutils.ActivityAndContextSet.activity;

public class DensityUtil {

    public static int dpToPx(float dpValue) {
        final float scale = activity.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale);
    }

    public static int px2dp(float pxValue) {
        final float scale = activity.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale);
    }
}
