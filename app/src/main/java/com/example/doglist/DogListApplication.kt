package com.example.doglist

import android.app.Application
import com.example.doglist.dagger.AppComponent
import com.example.doglist.dagger.AppModule
import com.example.doglist.dagger.DaggerAppComponent

class DogListApplication: Application(){
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}