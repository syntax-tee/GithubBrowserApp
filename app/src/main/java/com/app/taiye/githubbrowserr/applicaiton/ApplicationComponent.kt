package com.app.taiye.githubbrowserr.applicaiton

import android.content.Context
import com.app.taiye.githubbrowserr.githubapi.GithubApiModule
import com.app.taiye.githubbrowserr.repository.AppRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [GithubApiModule::class])
interface ApplicationComponent {

    fun  appRepository():AppRepository

    @Component.Factory
    interface  Factory{

        fun create(@BindsInstance context: Context):ApplicationComponent
    }

}