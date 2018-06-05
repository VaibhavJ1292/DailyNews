package com.dailynews.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Vaibhav Jadhav on 5/31/2018.
 */
data class FeedResponse(

        @SerializedName("status")
        @Expose
        private var status: String? = null,

        @SerializedName("totalResults")
        @Expose
        private var totalResults: Int? = null,

        @SerializedName("articles")
        @Expose
        private var articles: List<Article>? = null


)