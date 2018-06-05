package com.dailynews.utils

import android.util.Log
import com.dailynews.BuildConfig

/**
 * Created by Vaibhav Jadhav on 5/30/2018.
 */
object Logger {

    /**
     * To log debugs
     */
    fun d(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message)
        }
    }

    /**
     * To log errors
     */
    fun e(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, message)
        }
    }

    /**
     * To log infos
     */
    fun i(tag: String, message: String) {
        if (BuildConfig.DEBUG) {
            Log.i(tag, message)
        }
    }
}