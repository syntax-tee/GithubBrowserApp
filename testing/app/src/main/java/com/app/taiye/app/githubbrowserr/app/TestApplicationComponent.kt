package com.app.taiye.app.githubbrowserr.app

import android.content.Context
import com.app.taiye.app.githubbrowserr.app.githubapi.FakeGithubApi
import com.app.taiye.app.githubbrowserr.app.githubapi.TextGithubApiModule
import com.app.taiye.githubbrowserr.appcomponent.ApplicationComponent
import com.app.taiye.githubbrowserr.repository.AppRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules =  [TextGithubApiModule::class])
interface TestApplicationComponent :ApplicationComponent{

      fun githubApi():FakeGithubApi

        @Component.Factory
        interface  Factory{
            fun create(@BindsInstance context: Context):TestApplicationComponent
        }
}