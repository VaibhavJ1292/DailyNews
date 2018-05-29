package com.dailynews.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 * Created by Manoj on 5/29/2018.
 */
class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}