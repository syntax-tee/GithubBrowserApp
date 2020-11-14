package com.app.taiye.githubbrowserr.home

import androidx.lifecycle.ViewModel
import com.app.taiye.gtihubbrowserr.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeModule {


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindViewModel(homeViewModel: HomeViewModel):ViewModel

}