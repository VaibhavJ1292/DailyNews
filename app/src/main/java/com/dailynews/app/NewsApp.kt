package com.dailynews.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.dailynews.data.network.RetrofitClientHelper

/**
 * Created by Manoj on 5/29/2018.
 */
class NewsApp : Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitClientHelper.getRetrofitClient(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}