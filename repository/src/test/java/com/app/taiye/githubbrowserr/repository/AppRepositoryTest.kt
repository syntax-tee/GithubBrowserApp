package com.app.taiye.githubbrowserr.repository

import com.app.taiye.app.githubbrowserr.app.githubapi.FakeGithubApi
import com.app.taiye.githubbrowserr.githubapi.model.ContributorApiModel
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.app.taiye.githubbrowserr.githubapi.model.UserApiModel
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.runBlocking

private val fakeRepoApiModel = RepoApiModel(
    id = 1L,
    name = "Mock Repo",
    description = "Mock Repo Description",
    owner = UserApiModel(id = 1L, login = "dagger"),
    stargazersCount = 1,
    forksCount = 1,
    contributorsUrl = "http://",
    createdDate = "1/1/2020",
    updatedDate = "1/1/2020",
)

class AppRepositoryTest {

    private lateinit var  appRepository: AppRepository

    private val   fakeGitHubApi = FakeGithubApi().apply {  topRepos = listOf(fakeRepoApiModel) }

    @Before
    fun setUp(){
        appRepository = AppRepository(fakeGitHubApi)
    }


    @Test
    fun `getTopRepos returns result from GithubApi`(){

       val topRepos = runBlocking{
           appRepository.getTopRepos()
        }

        assertThat(topRepos.size).isEqualTo(1)
        assertThat(topRepos[0]).isEqualTo(fakeRepoApiModel)

    }

    @Test
    fun `getTopRepos returns cached result`(){
        val initialRequest = runBlocking {  appRepository.getTopRepos() }

        fakeGitHubApi.topRepos = listOf(fakeRepoApiModel, fakeRepoApiModel)

        val secondRequest = runBlocking {  appRepository.getTopRepos() }

        assertThat(initialRequest).isEqualTo(secondRequest)

    }


    @Test
     fun  `getRepo returns cached value`(){
        runBlocking { appRepository.getTopRepos() }

        //Set API to return different model on single repo fetch
        fakeGitHubApi.singleRepoResult = fakeRepoApiModel.copy(name = "Updated name")

        val singleRepoResultFetch = runBlocking {
            appRepository.getRepo(
                repoOwner = fakeRepoApiModel.owner.login,
                repoName =   fakeRepoApiModel.name
            )
        }

        assertThat(singleRepoResultFetch).isEqualTo(fakeRepoApiModel)
    }

    @Test
    fun `getRepo returns API value if not in cache`(){

        //seed cache
        runBlocking { appRepository.getTopRepos() }

        val expectedModel = fakeRepoApiModel.copy(name = "Updated Name")
        fakeGitHubApi.singleRepoResult = expectedModel

        val singleRepoFetchResult = runBlocking {
            appRepository.getRepo(
                repoOwner =  expectedModel.owner.login,
                repoName =   expectedModel.name
            )
        }

        assertThat(singleRepoFetchResult).isEqualTo(expectedModel)
    }


    @Test
    fun `getContributors returns API value`(){
        val expectedContributors = listOf(
            ContributorApiModel(
                id = 1L,
                login = "contributor",
                avatarUrl =  "avatar.png"

            ))

        fakeGitHubApi.contributorsResult = expectedContributors
        val contributors = runBlocking {
            appRepository.getContributors(fakeRepoApiModel.owner.login, fakeRepoApiModel.name)
        }

        assertThat(contributors).isEqualTo(expectedContributors)
    }

}


