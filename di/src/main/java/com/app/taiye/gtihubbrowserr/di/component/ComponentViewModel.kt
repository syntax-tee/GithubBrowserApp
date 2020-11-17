package com.app.taiye.gtihubbrowserr.di.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

class ComponentViewModel :ViewModel() {
  var  compnent:Any? = null

    override fun onCleared() {
        compnent = null
    }
}

fun <T> ViewModelStoreOwner.getComponent(createComponent:() -> T): T{
    val viewmodel = ViewModelProvider(this)[ComponentViewModel::class.java]
    if(viewmodel.compnent == null){
        viewmodel.compnent = createComponent()
    }

    @Suppress("UNCHECKED_CAST")
    return viewmodel.compnent as T
}