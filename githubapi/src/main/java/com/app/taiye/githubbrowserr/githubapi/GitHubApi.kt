package com.app.taiye.githubbrowserr.githubapi

import retrofit2.http.GET

interface GitHubApi {

    @GET("search/repositories?q=language:kotlin&order=desc&sort=stars")
    suspend   fun  getRepositories():TopSearchResult
}