package com.app.taiye.githubbrowserr.githubapi

import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopSearchResult(val items: List<RepoApiModel>)