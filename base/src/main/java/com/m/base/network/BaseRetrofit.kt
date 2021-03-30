package com.m.base.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BaseRetrofit @Inject constructor(
    private val gson: Gson,
    private val client: OkHttpClient
) {

    companion object {
        private val BASE_URL = "https://api.themoviedb.org/3/"
    }

    private val retrofit: Retrofit

    init {
        retrofit = initRetrofit()
    }

    private fun initRetrofit() =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .baseUrl(BASE_URL)
            .build()

    fun<T> create(serviceClass: Class<T>) = retrofit.create(serviceClass)
}