package com.example.projectwork.core.neatwork.service

import com.example.projectwork.core.model.popular.Popular
import com.example.projectwork.core.model.top_headline.TopHeadline
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmService {

    @GET("/3/movie/popular")
    suspend fun loadFilm(
        @Query("api_key") apiKey:String
    ):Response<Popular?>


    @GET("/3/movie/now_playing")
    suspend fun loadTopHeadline(
        @Query("api_key") apiKey:String
    ):Response<TopHeadline?>
}