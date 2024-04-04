package com.ozcanfatihcan.aurorayemeksiparis.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ozcanfatihcan.aurorayemeksiparis.R
import com.ozcanfatihcan.aurorayemeksiparis.data.entity.Food
import com.ozcanfatihcan.aurorayemeksiparis.databinding.HomeCardDesignBinding
import com.ozcanfatihcan.aurorayemeksiparis.ui.fragment.HomePageFragmentDirections
import com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel.HomePageViewModel
import com.ozcanfatihcan.aurorayemeksiparis.util.gecisYap

class FoodAdapter(var mContext:Context, var foodList: List<Food>,var viewModel:HomePageViewModel):RecyclerView.Adapter<FoodAdapter.FoodCardDesignHolder>() {

    inner class FoodCardDesignHolder(var design:HomeCardDesignBinding):RecyclerView.ViewHolder(design.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCardDesignHolder {
       val homeDesign:HomeCardDesignBinding=DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.home_card_design,parent,false)
        return FoodCardDesignHolder(homeDesign)
    }

    override fun onBindViewHolder(holder: FoodCardDesignHolder, position: Int) {
        val food=foodList.get(position)
        val d=holder.design

        d.foodObject=food

        val url= "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(500,700).into(d.imageFood)

        d.homeCard.setOnClickListener {
            val transition=HomePageFragmentDirections.gotoDetailFragment(food=food)
            Navigation.gecisYap(it,transition)
        }

        d.addButtonCard.setOnClickListener {

        }

        d.favButton.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}