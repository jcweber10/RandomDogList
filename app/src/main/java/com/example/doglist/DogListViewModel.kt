package com.example.doglist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Singleton


class DogListViewModel(
    application: Application,
    val repository: DogListRepository
) : AndroidViewModel(application) {

    @Singleton
    class Factory
    @Inject
    constructor(
        private val application: Application,
        private val repository: DogListRepository
    ) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DogListViewModel(application, repository) as T
        }
    }
}