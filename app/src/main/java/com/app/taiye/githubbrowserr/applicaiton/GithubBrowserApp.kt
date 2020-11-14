package com.app.taiye.githubbrowserr.applicaiton

import android.app.Application
import com.app.taiye.gtihubbrowserr.appdeps.ApplicationDeps
import com.app.taiye.gtihubbrowserr.appdeps.HasApplicationDeps

class GithubBrowserApp: Application(),HasApplicationDeps{

    private  val appComponent by lazy{
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getApplicationDeps(): ApplicationDeps {
        return appComponent
    }
}