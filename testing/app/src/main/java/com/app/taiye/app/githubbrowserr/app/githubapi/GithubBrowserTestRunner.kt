package com.app.taiye.app.githubbrowserr.app.githubapi

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import com.app.taiye.app.githubbrowserr.app.TestApplication

class GithubBrowserTestRunner: AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}