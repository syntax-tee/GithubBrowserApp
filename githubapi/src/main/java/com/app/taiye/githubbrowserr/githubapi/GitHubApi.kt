package com.app.taiye.githubbrowserr.githubapi

import com.app.taiye.githubbrowserr.githubapi.model.ContributorApiModel
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("search/repositories?q=language:kotlin&order=desc&sort=stars")
    suspend   fun  getRepositories():TopSearchResult


    @GET("repos/{owner}/name}")
    suspend fun getRepo(
        @Path("owner") repoOwner:String,
        @Path("name") repoName:String,
    ):RepoApiModel


    @GET("repos/{owner}/name}/contributors")
    suspend fun getContributors(
        @Path("owner") repoOwner:String,
        @Path("name") repoName:String,
    ):List<ContributorApiModel>


}