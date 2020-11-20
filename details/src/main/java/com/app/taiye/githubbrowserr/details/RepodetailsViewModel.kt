package com.app.taiye.githubbrowserr.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.taiye.githubbrowserr.details.list.ContributorItem
import com.app.taiye.githubbrowserr.repository.AppRepository
import com.app.taiye.gtihubbrowserr.di.scope.ScreenScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@ScreenScope
class RepoDetailsViewModel @Inject constructor(
    @Named("repo_owner") private val repoOwner: String,
    @Named("repo_name") private val repoName: String,
    private val appRepository: AppRepository
) : ViewModel() {

    private val repoInfoViewState = MutableLiveData<RepoInfoViewState>(RepoInfoViewStateLoading)
    val repoInfoUpdates: LiveData<RepoInfoViewState> = repoInfoViewState

    private val contributorsViewState =
        MutableLiveData<RepoContributorsViewState>(RepoContributorsViewStateLoading)
    val contributorsUpdates: LiveData<RepoContributorsViewState> = contributorsViewState

    init {
        viewModelScope.launch {
            val repo = appRepository.getRepo(repoOwner, repoName)
            repoInfoViewState.value = RepoInfoViewStateLoaded(
                repoName = repo.name,
                repoDescription = repo.description ?: "",
                createdDate = repo.createdDate,
                updatedDate = repo.updatedDate
            )
        }
        viewModelScope.launch {
            val contributors = appRepository.getContributors(repoOwner, repoName)
            contributorsViewState.value = RepoContributorsViewStateLoaded(
                contributors = contributors.map { apiModel ->
                    ContributorItem(
                        id = apiModel.id,
                        name = apiModel.login,
                        avatarUrl = apiModel.avatarUrl
                    )
                }
            )
        }
    }
}