package com.app.taiye.githubbrowserr.applicaiton

import android.app.Application
import com.app.taiye.githubbrowserr.appcomponent.DaggerApplicationComponent
import com.app.taiye.githubbrowserr.appdeps.ApplicationDeps
import com.app.taiye.githubbrowserr.appdeps.HasApplicationDeps

class GitHubBrowserApp : Application(), HasApplicationDeps {

    private  val appComponent by lazy{
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return appComponent
    }
}