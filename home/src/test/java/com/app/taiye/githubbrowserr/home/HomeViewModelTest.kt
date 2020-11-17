package com.app.taiye.githubbrowserr.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.app.taiye.githubbrowserr.githubapi.GitHubApi
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.app.taiye.githubbrowserr.githubapi.model.UseApiModel
import com.app.taiye.githubbrowserr.list.RepoItem
import com.app.taiye.githubbrowserr.repository.AppRepository
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule

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

class HomeViewModelTest {


    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: HomeViewModel
    private lateinit var  viewStateValues: MutableList<HomeViewState>

    @Before
    fun setUp() {
        val appRepository = AppRepository(FakeGitHubApi())
        viewStateValues = mutableListOf()

        viewModel = HomeViewModel(appRepository)
        viewModel.viewStateUpdates.observeForever({viewStateValues.add(it)})

    }



    @Test
    fun `load state contains repo models`() {
        assertThat(viewStateValues.size).isEqualTo(1)
        val expectedState = HomeViewStateLoaded(
            repos =  listOf(
                RepoItem(
                    name = fakeRepoApiModel.name,
                    description =  fakeRepoApiModel.description,
                    starsCount =   fakeRepoApiModel.stargazersCount,
                    forkCount =  fakeRepoApiModel.forksCount
                )
            )
        )

        assertThat(viewStateValues[0]).isEqualTo(expectedState)
    }
}


private class FakeGitHubApi: GitHubApi {

    override fun getRepositories(): List<RepoApiModel> {
        return listOf(fakeRepoApiModel)
    }

}