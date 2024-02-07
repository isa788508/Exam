package com.example.projectwork.core.neatwork

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.projectwork.core.app.App
import com.example.projectwork.core.neatwork.service.FilmService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object ApiClient {

    private fun getRetorfit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttp())
            .build()
    }

    private fun getOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(provideChunker())
            .build()
    }

    private fun provideChunker(): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(App.instance)
            .maxContentLength(250_000)
            .alwaysReadResponseBody(true)
            .build()
    }


    fun createService():FilmService= getRetorfit().create(FilmService::class.java)
}