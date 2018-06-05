package com.dailynews.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Vaibhav Jadhav on 5/31/2018.
 */
data class Article(

        @SerializedName("source")
        @Expose
        private var source: Source? = null,

        @SerializedName("author")
        @Expose
        private var author: String? = null,

        @SerializedName("title")
        @Expose
        private var title: String? = null,

        @SerializedName("description")
        @Expose
        private var description: String? = null,

        @SerializedName("url")
        @Expose
        private var url: String? = null,

        @SerializedName("urlToImage")
        @Expose
        private var urlToImage: String? = null,

        @SerializedName("publishedAt")
        @Expose
        private var publishedAt: String? = null
)