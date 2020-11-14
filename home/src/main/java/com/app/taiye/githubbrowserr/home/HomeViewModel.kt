package com.app.taiye.githubbrowserr.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.taiye.githubbrowserr.list.RepoItem
import com.app.taiye.githubbrowserr.repository.AppRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(appRepository: AppRepository):ViewModel() {

    private val _viewState = MutableLiveData<HomeViewState>(HomeViewStateLoading)

    val viewStateUpdates:LiveData<HomeViewState> = _viewState

    init {
        val topRepos = appRepository.getTopRepos()
        _viewState.value = HomeViewStateLoaded(
            repos = topRepos.map {
                 RepoItem(
                     name =  it.name,
                     description =   it.description,
                     starsCount =  it.stargazersCount,
                     forkCount =   it.forksCount
                 )
            }
        )
    }


}