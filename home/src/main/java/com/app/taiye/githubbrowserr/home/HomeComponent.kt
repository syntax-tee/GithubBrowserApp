package com.app.taiye.githubbrowserr.home

import com.app.taiye.gtihubbrowserr.appdeps.ApplicationDeps
import com.app.taiye.gtihubbrowserr.appdeps.applicationDeps
import dagger.Component


@Component(dependencies = [ApplicationDeps::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface  Factory {

        fun create(applicationDeps: ApplicationDeps):HomeComponent
    }
}

fun HomeFragment.inject(){

    DaggerHomeComponent.factory().create(requireContext()
         .applicationDeps())
         .inject(this)
}