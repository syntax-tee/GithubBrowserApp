package com.app.taiye.githubbrowserr.githubapi

import dagger.Binds
import dagger.Module


@Module
interface GithubApiModule {

    @Binds
    fun bindGithubApi(mockGithubApi: MockGithubApi):GitHubApi
}