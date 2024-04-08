package com.myutils;

import static com.myutils.ActivityAndContextSet.context;

import android.content.pm.PackageManager;
import android.content.res.Configuration;

public class DeviceTypeChecker {


    private static boolean isTablet() {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    private static boolean isAndroidTV() {
        // You may need to add additional conditions here to identify Android TV devices
        // For example, by checking if certain features are available or by using specific SDKs.
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_LEANBACK);
    }


    /**
     * return value has been ( TV, TABLET, PHONE )
     */
    public static String getDeviceType() {

        if (isAndroidTV()) {
            return "TV";
        } else if (isTablet()) {
            return "TABLET";
        } else {
            return "PHONE";
        }
    }
}
