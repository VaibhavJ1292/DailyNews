package com.dailynews.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.dailynews.BuildConfig
import com.dailynews.utils.Constants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Created by Vaibhav Jadhav on 5/30/2018.
 */
class HeaderInterceptor constructor(mContext: Context) : Interceptor {
    var mContext: Context

    init {
        this.mContext = mContext
    }

    override fun intercept(chain: Interceptor.Chain?): Response {

        if (!isOnline(mContext)) {
            throw IOException()
        }

        var request: Request ?= null
        request = chain?.request()?.newBuilder()
                ?.addHeader(Constants.API_KEY, BuildConfig.API_KEY)?.build() ?: chain?.request()?.newBuilder()?.build()

        return chain?.proceed(request)!!
    }

    /**
     * To check internet connection is available
     */
    private fun isOnline(mContext: Context): Boolean {
        val connectivityManager = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

}