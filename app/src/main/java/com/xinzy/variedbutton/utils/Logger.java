package com.xinzy.variedbutton.utils;

import android.util.Log;

/**
 * Created by Xinzy on 2017-01-04.
 */
public class Logger {

    private static final String TAG = "Varied";
    public static final boolean DEBUG = true;


    public static void e(String msg) {
        Log.e(TAG, msg);
    }
}
