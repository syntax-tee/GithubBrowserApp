package com.app.taiye.githubbrowserr.repository

import com.app.taiye.githubbrowserr.githubapi.GitHubApi
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepository @Inject constructor(private val gitHubApi: GitHubApi) {

    suspend fun getTopRepos():List<RepoApiModel>{
       return gitHubApi.getRepositories().items
    }
}