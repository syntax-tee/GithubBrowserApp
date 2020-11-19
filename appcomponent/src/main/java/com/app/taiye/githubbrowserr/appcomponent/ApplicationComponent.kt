package com.app.taiye.githubbrowserr.appcomponent

import android.content.Context
import com.app.taiye.githubbrowserr.githubapi.GitHubApiModule
import com.app.taiye.githubbrowserr.appdeps.ApplicationDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GitHubApiModule::class])
interface ApplicationComponent : ApplicationDeps {


    @Component.Factory
    interface  Factory{

        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}