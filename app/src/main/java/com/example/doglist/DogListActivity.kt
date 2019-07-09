package com.example.doglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DogListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_list)
        var fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment == null) {
            fragment = DogListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }

    }
}
