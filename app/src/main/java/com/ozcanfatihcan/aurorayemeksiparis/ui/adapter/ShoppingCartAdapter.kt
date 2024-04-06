package com.ozcanfatihcan.aurorayemeksiparis.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ozcanfatihcan.aurorayemeksiparis.R
import com.ozcanfatihcan.aurorayemeksiparis.data.entity.ShopCartFood
import com.ozcanfatihcan.aurorayemeksiparis.databinding.ShoppingCardDesignBinding
import com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel.ShoppingCartPageViewModel

class ShoppingCartAdapter(var mContext:Context,
                          var shopCartList:List<ShopCartFood>,
                          var viewModel:ShoppingCartPageViewModel):RecyclerView.Adapter<ShoppingCartAdapter.ShopCardDesignHolder>() {

    inner class ShopCardDesignHolder(var design:ShoppingCardDesignBinding):RecyclerView.ViewHolder(design.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopCardDesignHolder {
        val shopDesign:ShoppingCardDesignBinding=DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.shopping_card_design,parent,false)
        return ShopCardDesignHolder(shopDesign)
    }

    override fun onBindViewHolder(holder: ShopCardDesignHolder, position: Int) {
        val shopCart=shopCartList.get(position)
        val d=holder.design

        d.shopCartFoodObject=shopCart
        val url= "http://kasimadalan.pe.hu/yemekler/resimler/${shopCart.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(500,700).into(d.imageShopFood)

        d.shopDesignDeleteButton.setOnClickListener {

        }

    }

    override fun getItemCount(): Int {
        return shopCartList.size
    }
}