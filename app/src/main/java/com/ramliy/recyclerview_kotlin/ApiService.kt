package com.ramliy.recyclerview_kotlin

import com.ramliy.recyclerview_kotlin.model.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by ramliy10 on 02/04/20.
 */
interface ApiService {
    @GET("3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Call<HomeResponse>
}
