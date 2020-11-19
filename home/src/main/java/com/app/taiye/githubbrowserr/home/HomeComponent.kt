package com.app.taiye.githubbrowserr.home

import com.app.taiye.githubbrowserr.appdeps.ApplicationDeps
import com.app.taiye.githubbrowserr.appdeps.applicationDeps
import com.app.taiye.gtihubbrowserr.di.component.getComponent
import com.app.taiye.gtihubbrowserr.di.scope.ScreenScope
import dagger.Component


@ScreenScope
@Component(dependencies = [ApplicationDeps::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface  Factory {

        fun create(applicationDeps: ApplicationDeps):HomeComponent
    }
}

fun HomeFragment.inject(){

    getComponent {
        DaggerHomeComponent.factory().create(requireContext()
            .applicationDeps())
    }.inject(this)
}