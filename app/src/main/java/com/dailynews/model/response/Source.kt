package com.dailynews.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by Vaibhav Jadhav on 5/31/2018.
 */
data class Source(

        @SerializedName("id")
        @Expose
        private var id: Any? = null,

        @SerializedName("name")
        @Expose
        private var name: String? = null

)