package com.example.doglist

import com.example.doglist.data.Dog
import com.example.doglist.data.remote.DogApi
import javax.inject.Inject

class DogListRepository @Inject constructor(private val dogApi: DogApi) {

    suspend fun getRandomDogs() = dogApi.getRandomDogs()
}