package com.app.taiye.githubbrowserr.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.app.taiye.app.githubbrowserr.app.githubapi.FakeGithubApi
import com.app.taiye.githubbrowserr.githubapi.model.RepoApiModel
import com.app.taiye.githubbrowserr.githubapi.model.UserApiModel
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
    owner = UserApiModel(1,"Taiye"),
    "",
    34,
    1,
    "",
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
        val appRepository = AppRepository(FakeGithubApi().apply { repos = listOf(fakeRepoApiModel) })
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
                    description =  fakeRepoApiModel.description?:"",
                    starsCount =   fakeRepoApiModel.stargazersCount,
                    forkCount =  fakeRepoApiModel.forksCount
                )
            )
        )

        assertThat(viewStateValues[0]).isEqualTo(expectedState)
    }
}