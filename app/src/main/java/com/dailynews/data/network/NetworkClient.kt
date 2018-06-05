package com.dailynews.data.network

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vaibhav Jadhav on 5/31/2018.
 */
class NetworkClient constructor(networkServices: NetworkServices) {

    var mNetworkServices: NetworkServices? = null

    init {
        this.mNetworkServices = networkServices
    }

    public fun getNews(language: String, category: String): Disposable? {
        return mNetworkServices?.getNews()
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeOn(Schedulers.io())
                ?.subscribe(Consumer { t -> Log.d("News", t.toString()) }, Consumer { t -> Log.d("News", t.toString()) })
    }
}