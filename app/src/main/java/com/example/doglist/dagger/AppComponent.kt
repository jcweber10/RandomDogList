package com.example.doglist.dagger

import com.example.doglist.DogListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(target: DogListFragment)
}