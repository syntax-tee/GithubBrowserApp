package com.app.taiye.githubbrowserr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.taiye.githubbrowserr.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.screen_container, HomeFragment())
                .commit()
        }
    }
}