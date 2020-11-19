package com.app.taiye.app.githubbrowserr.app.githubapi

import com.app.taiye.githubbrowserr.githubapi.GitHubApi
import com.app.taiye.githubbrowserr.githubapi.TopSearchResult
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FakeGithubApi @Inject constructor():GitHubApi {

    var repos = listOf<RepoApiModel>()

    override suspend fun getRepositories(): TopSearchResult {
        return TopSearchResult(repos)
    }

    override suspend fun getRepo(repoOwner: String, repoName: String): RepoApiModel {
        TODO("Not yet implemented")
    }

    override suspend fun getContributors(repoOwner: String, repoName: String): RepoApiModel {
        TODO("Not yet implemented")
    }


}