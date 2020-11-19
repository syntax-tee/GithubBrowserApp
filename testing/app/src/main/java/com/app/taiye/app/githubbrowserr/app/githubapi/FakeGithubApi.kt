package com.app.taiye.app.githubbrowserr.app.githubapi

import com.app.taiye.githubbrowserr.githubapi.GitHubApi
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FakeGithubApi @Inject constructor():GitHubApi {

    var repos = listOf<RepoApiModel>()
    override suspend fun getRepositories(): List<RepoApiModel> {
        return repos
    }


}