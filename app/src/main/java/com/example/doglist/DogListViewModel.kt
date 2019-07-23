package com.example.doglist

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.doglist.data.Dog
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton


class DogListViewModel(
    application: Application,
    val repository: DogListRepository
) : AndroidViewModel(application) {

    companion object {
        private const val TAG = "DogListViewModel"
    }

    val requestInProgress: MutableLiveData<Boolean> = MutableLiveData()
    val dogs: MutableLiveData<List<Dog>> = MutableLiveData()

    fun getDogs() {
        viewModelScope.launch {
            requestInProgress.value = true
            try {
                dogs.value = repository.getRandomDogs()
                Log.v(TAG, "Got ${dogs.value?.size} dogs")
            } catch (exception: Exception) {
                Log.e(TAG, "Exception retrieving dogs", exception)
            } finally {
                requestInProgress.value = false
            }
        }
    }

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