package com.ozcanfatihcan.aurorayemeksiparis.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ozcanfatihcan.aurorayemeksiparis.R
import com.ozcanfatihcan.aurorayemeksiparis.data.entity.Food
import com.ozcanfatihcan.aurorayemeksiparis.databinding.FragmentHomePageBinding
import com.ozcanfatihcan.aurorayemeksiparis.ui.adapter.FoodAdapter
import com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    private lateinit var viewModel:HomePageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home_page,container,false)
        binding.homePageObject=this

        viewModel.foodList.observe(viewLifecycleOwner){
            binding.foodAdapter= FoodAdapter(requireContext(),it,viewModel)
        }

        binding.searchView.setOnQueryTextListener(object:OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String?): Boolean {
                newText?.let { viewModel.searchFood(it)
                     }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let { viewModel.searchFood(it)
                     }
                return true
            }

        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:HomePageViewModel by viewModels()
        viewModel=tempViewModel
    }


/*
    override fun onResume() {
        super.onResume()
        viewModel.getFood()
    }*/
}