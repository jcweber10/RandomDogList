package com.example.doglist.dagger

import android.app.Application
import android.content.Context
import com.example.doglist.data.remote.DogApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesContext(): Context = application

    @Provides
    @Singleton
    fun providesConverterFactory() = MoshiConverterFactory.create()

    @Provides
    @Singleton
    fun providesRetrofit(converterFactory: MoshiConverterFactory) = Retrofit.Builder()
        .baseUrl(DogApi.BASE_URL)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    @Singleton
    fun providesDogApi(retrofit: Retrofit) = retrofit.create(DogApi::class.java)

}