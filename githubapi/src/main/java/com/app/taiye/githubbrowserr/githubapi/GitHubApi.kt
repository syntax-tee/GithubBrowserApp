package com.app.taiye.githubbrowserr.githubapi

import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.app.taiye.githubbrowserr.githubapi.model.UseApiModel
import javax.inject.Inject
import javax.inject.Singleton

interface GitHubApi {
    suspend   fun  getRepositories():TopSearchResult
}


@Singleton
class MockGithubApi @Inject constructor():GitHubApi {

    override suspend fun getRepositories(): TopSearchResult {

         return  TopSearchResult(listOf(RepoApiModel(
            1L,
             "Taiye",
             "Emmanuel",
              owner = UseApiModel(1,"Taiye"),
             2,
             5,
             "taiye/com",
             "1/1/2020",
             "1/1/2020"
        ),
             RepoApiModel(
                 1L,
                 "Mo",
                 "Deborah",
                 owner = UseApiModel(1,"Taiye"),
                 2,
                 4,
                 "taiye/com",
                 "1/1/2020",
                 "1/1/2020"
             )
         ,RepoApiModel(
                 1L,
                 "Samuel",
                 "Kenny",
                 owner = UseApiModel(1,"Taiye"),
                 2,
                 3,
                 "taiye/com",
                 "1/1/2020",
                 "1/1/2020"
             )))
    }


}