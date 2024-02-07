package com.example.projectwork.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projectwork.core.model.popular.Popular
import com.example.projectwork.core.model.top_headline.TopHeadline
import com.example.projectwork.core.repository.FilmRepository
import com.example.projectwork.core.utill.ResultWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = FilmRepository()

    val filmsNowLiveData: MutableLiveData<TopHeadline> = MutableLiveData()
    val filmsPopularLiveData: MutableLiveData<Popular> = MutableLiveData()
    val errorLiveData: MutableLiveData<String?> = MutableLiveData()

    fun getFilmsData() {


        CoroutineScope(Dispatchers.IO).launch {
            val resultNow = repository.getBannerNotes()
            val resultPopular = repository.getPopularItem()

            when (resultNow) {
                is ResultWrapper.Success -> {
                    resultNow.response?.let {
                        filmsNowLiveData.value = it
                    }
                }

                is ResultWrapper.Error -> {
                    errorLiveData.value = resultNow.message.toString()

                }
            }


        }
    }

    fun getPopular() {
        CoroutineScope(Dispatchers.IO).launch {
            val resultPopular = repository.getPopularItem()

            when (resultPopular) {
                is ResultWrapper.Success -> {
                    resultPopular.response?.let {
                        filmsPopularLiveData.value = it
                    }
                }

                is ResultWrapper.Error -> {
                    errorLiveData.value = resultPopular.message.toString()
                }
            }

        }

    }
}