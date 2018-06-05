package com.dailynews.ui.feeds

import com.dailynews.model.response.FeedResponse
import com.dailynews.ui.base.BaseContractor

/**
 * Created by Vaibhav Jadhav on 5/30/2018.
 */
interface FeedContractor {

    interface Presenter : BaseContractor.BasePresenter {
        fun fetchNews(category: String, country: String)
        fun handleNewsResponse(feedResponse: FeedResponse)
        fun refreshNewsCards(category: String, country: String)
    }

    interface View : BaseContractor.BaseView {
        fun displayTopHeadLines(feedResponse: FeedResponse)
    }
}