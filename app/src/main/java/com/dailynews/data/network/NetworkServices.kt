package com.dailynews.data.network

import com.dailynews.model.response.FeedResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Vaibhav Jadhav on 5/30/2018.
 */
interface NetworkServices {

    @GET("/v2/top-headlines")
     public fun getNews():Observable<FeedResponse>

}