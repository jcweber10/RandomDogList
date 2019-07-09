package com.example.doglist.data.remote

import com.example.doglist.data.Dog
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApi {
    companion object {
        val BASE_URL = "https://dog.ceo/api/"
    }

    @GET("breeds/image/random/{count}")
    suspend fun getRandomDogs(@Path("count") count: Int = 50): List<Dog>
}