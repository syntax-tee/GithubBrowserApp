package com.app.taiye.githubbrowserr.githubapi

import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.app.taiye.githubbrowserr.githubapi.model.UseApiModel

interface GitHubApi {
    fun getRepositories():List<RepoApiModel>
}

class MockGithubApi:GitHubApi{
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