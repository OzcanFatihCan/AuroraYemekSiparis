package com.ozcanfatihcan.aurorayemeksiparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ozcanfatihcan.aurorayemeksiparis.R
import com.ozcanfatihcan.aurorayemeksiparis.databinding.FragmentFavoritePageBinding
import com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel.FavoritePageViewModel


class FavoritePageFragment : Fragment() {
    private lateinit var binding: FragmentFavoritePageBinding
    private lateinit var viewModel:FavoritePageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_favorite_page, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:FavoritePageViewModel by viewModels()
        viewModel=tempViewModel
    }
}