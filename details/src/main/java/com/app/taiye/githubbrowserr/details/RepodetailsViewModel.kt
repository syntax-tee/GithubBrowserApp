package com.app.taiye.githubbrowserr.details

import androidx.lifecycle.ViewModel
import com.app.taiye.githubbrowserr.repository.AppRepository
import com.app.taiye.gtihubbrowserr.di.scope.ScreenScope
import javax.inject.Inject
import javax.inject.Named


@ScreenScope
class RepodetailsViewModel  @Inject constructor(@Named("repo_owner") private val repoOwner:String,
                                                @Named("repo_name") private val repoName:String,
                                                private  val appRepository: AppRepository
): ViewModel() {

}