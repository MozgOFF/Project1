package com.example.project1;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesWrapper {
    private static String SHARED_PREF = "MyApplication";

    public static final String PREF_LOGIN = "login";
    public static final String PREF_PASSWORD = "password"; //Capital constants?

    private static SharedPreferences getSharedPref(Context context) {
        return context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
    }

    public static void saveLogin(Context context, String login) {
        getSharedPref(context).edit().putString(PREF_LOGIN, login).apply();
    }

    public static String getLogin(Context context) {
        return getSharedPref(context).getString(PREF_LOGIN, null);
    }

    public static void savePassword(Context context, String password) {
        getSharedPref(context).edit().putString(PREF_PASSWORD, password).apply();
    }

    public static String getPassword(Context context) {
        return getSharedPref(context).getString(PREF_PASSWORD, null);
    }

    public static void logout(Context context) {
        getSharedPref(context).edit().clear().apply();
//        getLogin(context);
//        getPassword(context);
    }
}
