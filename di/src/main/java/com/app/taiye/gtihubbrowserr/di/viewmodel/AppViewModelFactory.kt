package com.app.taiye.gtihubbrowserr.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.NullPointerException
import javax.inject.Inject
import javax.inject.Provider

class AppViewModelFactory @Inject constructor(
    private val  classToViewModel: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
):ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
     return  classToViewModel[modelClass]?.get() as? T ?: throw  NullPointerException("No view model mapping for class:${modelClass.name}")
    }

}