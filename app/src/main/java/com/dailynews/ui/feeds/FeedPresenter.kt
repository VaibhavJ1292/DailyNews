package com.dailynews.ui.feeds

import com.dailynews.data.network.NetworkClient
import com.dailynews.data.network.RetrofitClientHelper
import io.reactivex.disposables.Disposable

/**
 * Created by Vaibhav Jadhav on 5/31/2018.
 */
class FeedPresenter<T : FeedContractor.View> constructor(mView: T) : FeedContractor.Presenter {


    private lateinit var mView: FeedContractor.View
    private lateinit var disposable: Disposable
    private lateinit var mNetworkClient: NetworkClient

    init {
        this.mView = mView
        mNetworkClient = NetworkClient(RetrofitClientHelper.getNetworkServices())
    }

    override fun cancelRequest() {
        if (disposable.isDisposed) {
            disposable.dispose()
        }

    }

    override fun handleError(throwable: Throwable) {
    }


}