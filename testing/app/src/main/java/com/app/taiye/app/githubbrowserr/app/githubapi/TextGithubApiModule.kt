package com.app.taiye.app.githubbrowserr.app.githubapi

import com.app.taiye.githubbrowserr.githubapi.GitHubApi
import dagger.Binds
import dagger.Module


@Module
interface TextGithubApiModule {

    @Binds
    fun bindGithubApi(fakeGithubApi: FakeGithubApi):GitHubApi
}