package com.socratesdiaz.chucknorrisquotes.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by socratesdiaz on 10/5/17.
 */
interface ApiService {
    companion object {
        val BASE_URL = "https://api.icndb.com/"
    }

    @GET("jokes/random/")
    // If count is an empty string, fetch only one joke
    fun getRandomJoke() : Observable<ApiResponse<Joke>>

    @GET("jokes/random/{count}")
    fun getRandomJokes(@Path("count") count:Int) : Observable<ApiResponse<List<Joke>>>

    @GET("jokes/count")
    fun getJokesCount() : Observable<ApiResponse<Int>>

    @GET("jokes/{id}")
    fun getJoke(@Path("id") id:Int) : Observable<ApiResponse<Joke>>
}