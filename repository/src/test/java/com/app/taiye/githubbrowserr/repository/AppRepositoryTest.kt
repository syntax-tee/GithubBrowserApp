package com.app.taiye.githubbrowserr.repository

import com.app.taiye.githubbrowserr.githubapi.GitHubApi
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.app.taiye.githubbrowserr.githubapi.model.UseApiModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


private val fakeRepoApiModel =    RepoApiModel(
    1L,
    "Taiye",
    "Nice Guy",
    owner = UseApiModel(1,"Taiye"),
    2,
    34,
    "taiye/com",
    "1/1/2020",
    "1/1/2020"
)

class AppRepositoryTest {

    private lateinit var  appRepository: AppRepository

    private val fakeGitHubApi = FakeGitHubApi()

    @Before
    fun setUp(){
        appRepository = AppRepository(fakeGitHubApi)
    }


    @Test
    fun successfulQuery(){
        val topRepos= appRepository.getTopRepos()
        assertThat(topRepos.size).isEqualTo(1)
        assertThat(topRepos[0]).isEqualTo(fakeRepoApiModel)

    }
}


private class FakeGitHubApi:GitHubApi {

    override fun getRepositories(): List<RepoApiModel> {
        return listOf(fakeRepoApiModel)
    }

}