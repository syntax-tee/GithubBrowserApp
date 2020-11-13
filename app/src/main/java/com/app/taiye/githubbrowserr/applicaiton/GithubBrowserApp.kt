package com.app.taiye.githubbrowserr.applicaiton

import android.app.Application

class GithubBrowserApp: Application() {

    private  val appComponent by lazy{
        DaggerApplicationComponent.factory().create(this)
    }
}