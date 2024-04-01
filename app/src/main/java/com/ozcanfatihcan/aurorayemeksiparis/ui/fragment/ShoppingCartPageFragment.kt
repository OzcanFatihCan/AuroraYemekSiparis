package com.ozcanfatihcan.aurorayemeksiparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ozcanfatihcan.aurorayemeksiparis.R
import com.ozcanfatihcan.aurorayemeksiparis.databinding.FragmentShoppingCartPageBinding
import com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel.ShoppingCartPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingCartPageFragment : Fragment() {
    private lateinit var binding: FragmentShoppingCartPageBinding
    private lateinit var viewModel:ShoppingCartPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_shopping_cart_page, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:ShoppingCartPageViewModel by viewModels()
        viewModel=tempViewModel
    }
}