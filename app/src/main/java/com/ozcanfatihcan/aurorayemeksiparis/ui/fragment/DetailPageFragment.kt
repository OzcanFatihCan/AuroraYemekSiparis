package com.ozcanfatihcan.aurorayemeksiparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ozcanfatihcan.aurorayemeksiparis.R
import com.ozcanfatihcan.aurorayemeksiparis.databinding.FragmentDetailPageBinding
import com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel.DetailPageViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailPageFragment : Fragment() {
    private lateinit var binding: FragmentDetailPageBinding
    private lateinit var viewModel:DetailPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detail_page, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetailPageViewModel by viewModels()
        viewModel=tempViewModel
    }

}