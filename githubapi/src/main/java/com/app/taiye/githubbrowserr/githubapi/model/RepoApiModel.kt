package com.app.taiye.githubbrowserr.githubapi.model

data  class RepoApiModel(
    val id:Long,
    val name:String,
    val description:String,
    val owner:UseApiModel,
    val stargazersCount :Int,
    val forksCount: Int,
    val contributorUrl:String,
    val createdDate:String,
    val updateDate:String
)