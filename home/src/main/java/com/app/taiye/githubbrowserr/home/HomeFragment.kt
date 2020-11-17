package com.app.taiye.githubbrowserr.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.taiye.githubbrowserr.home.databinding.ScreenHomeBinding
import com.app.taiye.githubbrowserr.list.HomeRepoAdapter
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
        binding.repoList.apply {
            adapter = HomeRepoAdapter()
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        }

        homeViewModel.viewStateUpdates.observe(viewLifecycleOwner, Observer { state ->
            when(state){
              is   HomeViewStateLoading -> handleLoadingState(binding)
              is HomeViewStateLoaded ->    handleLoadedState(state,binding)
              is HomeViewStateError ->     handleStateError(state, binding)
            }
        })
        return  binding.root
    }

    private fun handleStateError(state: HomeViewStateError, binding: ScreenHomeBinding) {
        binding.repoList.visibility = View.GONE
        binding.loadingIndicator.visibility = View.GONE
        binding.errorTextView.visibility = View.VISIBLE
        binding.errorTextView.text = state.message
    }

    private fun handleLoadedState(state: HomeViewStateLoaded, binding: ScreenHomeBinding) {
        binding.errorTextView.visibility = View.GONE
        binding.loadingIndicator.visibility = View.GONE

        binding.repoList.visibility = View.VISIBLE
        (binding.repoList.adapter as HomeRepoAdapter).setRepoItems(state.repos)
    }

    private fun handleLoadingState(binding: ScreenHomeBinding) {
        binding.errorTextView.visibility = View.GONE
        binding.repoList.visibility = View.GONE
        binding.loadingIndicator.visibility = View.VISIBLE
    }
}