package com.myutils;

import static com.myutils.ActivityAndContextSet.activity;
import static com.myutils.ActivityAndContextSet.context;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Locale;

@SuppressLint("StaticFieldLeak")
public class SPUtilsStatic {

    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;

    public static void initSessionManager(String name) {
        pref = context.getSharedPreferences(name, 0);
        editor = pref.edit();
    }

    public static void removeAll() {
        String language = "";
        if (getLanguage().equals("hi")) {
            language = "hi";
        }
        editor.clear().apply();
        editor.putString("language", language);
        editor.commit();
    }

    public static void setLanguage(String language) {
        editor.putString("language", language);
        editor.commit();
        setLocale(language);
        activity.recreate();
    }

    public static String getLanguage() {
        return pref.getString("language", "");
    }

    public static void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }


    public static void setInt(String KEY, int value) {
        editor.putInt(KEY, value);
        editor.commit();
    }

    public static int getInt(String KEY) {
        return pref.getInt(KEY, 0);
    }

    public static int getInt(String KEY, int defaultValue) {
        return pref.getInt(KEY, defaultValue);
    }


    public static void setString(String KEY, String value) {
        editor.putString(KEY, value);
        editor.commit();
    }

    public static String getString(String KEY) {
        return pref.getString(KEY, "");
    }

    public static String getString(String KEY, String defaultValue) {
        return pref.getString(KEY, defaultValue);
    }


    public static void setBoolean(String KEY, boolean value) {
        editor.putBoolean(KEY, value);
        editor.commit();
    }

    public static boolean getBoolean(String KEY) {
        return pref.getBoolean(KEY, false);
    }

    public static boolean getBoolean(String KEY, boolean defaultValue) {
        return pref.getBoolean(KEY, defaultValue);
    }


    public static void setFloat(String KEY, float value) {
        editor.putFloat(KEY, value);
        editor.commit();
    }

    public static Float getFloat(String KEY) {
        return pref.getFloat(KEY, 0f);
    }

    public static Float getFloat(String KEY, float defaultValue) {
        return pref.getFloat(KEY, defaultValue);
    }


    public static void setLong(String KEY, long value) {
        editor.putLong(KEY, value);
        editor.commit();
    }

    public static long getLong(String KEY) {
        return pref.getLong(KEY, 0);
    }

    public static long getLong(String KEY, long defaultValue) {
        return pref.getLong(KEY, defaultValue);
    }


    public static void setDouble(String KEY, double value) {
        editor.putString(KEY, String.valueOf(value));
        editor.commit();
    }

    public static double getDouble(String KEY) {
        return Double.parseDouble(pref.getString(KEY, "0"));
    }

    public static double getDouble(String KEY, double defaultValue) {
        String value = pref.getString(KEY, null);
        if (value != null)
            return Double.parseDouble(value);
        else
            return defaultValue;
    }


    // ArrayList

    public static <T> void saveArrayList(String KEY, ArrayList<T> arrayList) {
        Gson gson = new Gson();
        String json = gson.toJson(arrayList);
        editor.putString(KEY, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public static <T> ArrayList<T> getArrayList(String KEY) {
        ArrayList<T> arrayList;
        String json = pref.getString(KEY, null);
        Type type = new TypeToken<ArrayList<Object>>() {
        }.getType();
        arrayList = new Gson().fromJson(json, type);
        if (arrayList != null)
            return arrayList;
        else
            return new ArrayList<>();
    }


    // Object
    public static void saveObject(String KEY, Object o) {
        Gson gson = new Gson();
        String json = gson.toJson(o);
        editor.putString(KEY, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public static Object getObject(String KEY, Class<?> classOfT) {
        Object o;
        String json = pref.getString(KEY, null);
        Type type = TypeToken.getParameterized(classOfT).getType();
        o = new Gson().fromJson(json, type);
        if (o != null)
            return o;
        else
            return new Object();
    }
}
