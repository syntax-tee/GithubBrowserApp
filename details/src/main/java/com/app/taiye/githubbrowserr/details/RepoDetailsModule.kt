package com.app.taiye.githubbrowserr.details

import androidx.lifecycle.ViewModel
import com.app.taiye.gtihubbrowserr.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RepoDetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(RepodetailsViewModel::class)
    fun bindViewModel(repodetailsViewModel: RepodetailsViewModel):ViewModel
}