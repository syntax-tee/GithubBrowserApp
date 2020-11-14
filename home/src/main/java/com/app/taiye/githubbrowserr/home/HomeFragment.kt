package com.app.taiye.githubbrowserr.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.app.taiye.githubbrowserr.home.databinding.ScreenHomeBinding
import com.app.taiye.gtihubbrowserr.di.viewmodel.AppViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private val homeViewModel:HomeViewModel by lazy {
         ViewModelProvider(this,appViewModelFactory)[HomeViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = ScreenHomeBinding.inflate(inflater,container,false)
        return  binding.root
    }
}