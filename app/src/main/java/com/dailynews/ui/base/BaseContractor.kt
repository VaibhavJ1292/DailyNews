package com.dailynews.ui.base

import android.content.res.Resources

/**
 * Created by Vaibhav Jadhav on 5/29/2018.
 */
interface BaseContractor {

    interface BasePresenter {
        fun handleError(throwable: Throwable)
        fun cancelRequest()
    }

    interface BaseView {
        fun showProgress()
        fun hideProgress()
        fun showMessage(message: String)
        fun showCancelableProgress()
        fun handleError(throwable: Throwable)

        fun getResources(): Resources
    }
}