package com.socratesdiaz.chucknorrisquotes.base

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.socratesdiaz.chucknorrisquotes.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by socratesdiaz on 10/5/17.
 */
abstract class BaseModel : MvpModel {
    var gson : Gson = GsonBuilder().create()

    val apiService : ApiService by lazy {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.networkInterceptors().add(loggingInterceptor)

        val client = clientBuilder.build()

        val retrofit =
                Retrofit.Builder().baseUrl(ApiService.BASE_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()

        retrofit.create(ApiService::class.java)
    }
}