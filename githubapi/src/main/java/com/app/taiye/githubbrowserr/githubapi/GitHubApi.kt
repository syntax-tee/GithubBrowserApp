package com.app.taiye.githubbrowserr.githubapi

import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.app.taiye.githubbrowserr.githubapi.model.UseApiModel
import javax.inject.Inject
import javax.inject.Singleton

interface GitHubApi {
    fun getRepositories():List<RepoApiModel>
}


@Singleton
class MockGithubApi @Inject constructor():GitHubApi {

    override fun getRepositories(): List<RepoApiModel> {

         return  listOf(RepoApiModel(
            1L,
             "Taiye",
             "Nice Guy",
              owner = UseApiModel(1,"Taiye"),
             2,
             34,
             "taiye/com",
             "1/1/2020",
             "1/1/2020"
        ))
    }


}