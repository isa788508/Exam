package com.example.projectwork.core.repository

import com.example.projectwork.core.model.popular.Popular
import com.example.projectwork.core.model.top_headline.TopHeadline
import com.example.projectwork.core.neatwork.ApiClient
import com.example.projectwork.core.utill.ResultWrapper
import java.io.IOException

class FilmRepository {

    private val service = ApiClient.createService()


    suspend fun getBannerNotes(): ResultWrapper<TopHeadline, Any> {

        return try {
            val result = service.loadTopHeadline("10137bab07a7a987b23a902a78d6986c ")

            if (result.isSuccessful) {
                ResultWrapper.Success(result.body(), result.code())
            } else {
                ResultWrapper.Error(result.message(), result.code())
            }
        } catch (e: IOException) {
            ResultWrapper.Error("Internet Yoq")
        } catch (e: Exception) {
            ResultWrapper.Error(e.message)
        }
    }


    suspend fun getPopularItem(): ResultWrapper<Popular, Any> {

        return try {
            val result = service.loadFilm("10137bab07a7a987b23a902a78d6986c")
            if (result.isSuccessful) {
                ResultWrapper.Success(result.body(), result.code())
            } else {
                ResultWrapper.Error(result.message(), result.code())
            }
        } catch (e: IOException) {
            ResultWrapper.Error("Internet Yoq")
        } catch (e: Exception) {
            ResultWrapper.Error(e.message)
        }
    }
}