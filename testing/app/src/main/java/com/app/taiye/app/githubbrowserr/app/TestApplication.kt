package com.app.taiye.app.githubbrowserr.app

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.app.taiye.githubbrowserr.appdeps.ApplicationDeps
import com.app.taiye.githubbrowserr.appdeps.HasApplicationDeps

class TestApplication: Application(), HasApplicationDeps {

    private lateinit var component: TestApplicationComponent


    override fun onCreate() {
        super.onCreate()

        component = DaggerTestApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return component
    }

    companion object{
        val component:TestApplicationComponent
        get() = (InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApplication).component
    }
}