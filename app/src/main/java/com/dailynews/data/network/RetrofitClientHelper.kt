@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.dailynews.data.network

import android.content.Context
import com.dailynews.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Vaibhav Jadhav on 5/30/2018.
 */
object RetrofitClientHelper {

    var mNetworkServices: NetworkServices? = null

    var httpClient: OkHttpClient.Builder? = null


    /**
     * To build retrofit object
     */
    fun getRetrofitClient(mContext: Context) {
        httpClient = OkHttpClient.Builder().apply {
            addInterceptor(HeaderInterceptor(mContext))
            addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            readTimeout(5000, TimeUnit.SECONDS)
            writeTimeout(5000, TimeUnit.SECONDS)
            connectTimeout(5000, TimeUnit.SECONDS)
        }

        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient?.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()


        mNetworkServices = retrofit.create(NetworkServices::class.java)
    }

    /**
     * To connect network service
     */
    fun getNetworkServices(): NetworkServices {
        return mNetworkServices as NetworkServices
    }

}