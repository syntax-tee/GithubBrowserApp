package com.app.taiye.app.githubbrowserr.app.githubapi

import com.app.taiye.githubbrowserr.githubapi.GitHubApi
import com.app.taiye.githubbrowserr.githubapi.TopSearchResult
import com.app.taiye.githubbrowserr.githubapi.model.ContributorApiModel
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class FakeGithubApi @Inject constructor():GitHubApi {

    var topRepos = listOf<RepoApiModel>()
    var singleRepoResult:RepoApiModel? = null
    var contributorsResult: List<ContributorApiModel> = listOf<ContributorApiModel>( )

    override suspend fun getRepositories(): TopSearchResult {
        return TopSearchResult(topRepos)
    }

    override suspend fun getRepo(repoOwner: String, repoName: String): RepoApiModel {
        return  singleRepoResult ?: throw  NullPointerException("singleRepo result")
    }

    override suspend fun getContributors(repoOwner: String, repoName: String): List<ContributorApiModel> {
        return contributorsResult
    }


}