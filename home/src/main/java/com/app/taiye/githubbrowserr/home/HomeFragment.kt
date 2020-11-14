package com.app.taiye.githubbrowserr.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.taiye.githubbrowserr.home.databinding.ScreenHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = ScreenHomeBinding.inflate(inflater,container,false)
        return  binding.root
    }
}