package com.app.taiye.githubbrowserr.githubapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ContributorApiModel(
    val id: Long,
    val logiin:String,
    @Json(name = "avatar_url") val avatarUrl:String) {
}