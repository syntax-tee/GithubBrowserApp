package com.app.taiye.githubbrowserr.home

import com.app.taiye.githubbrowserr.list.RepoItem

sealed  class HomeViewState
object HomeViewStateLoading: HomeViewState()
data class HomeViewStateLoaded(val repos:List<RepoItem>):HomeViewState()
data class HomeViewStateError(val message:String):HomeViewState()