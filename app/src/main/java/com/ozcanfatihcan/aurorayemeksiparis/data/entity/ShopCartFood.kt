package com.ozcanfatihcan.aurorayemeksiparis.data.entity

data class ShopCartFood(
    var sepet_yemek_id:Int,
    var yemek_adi:String,
    var yemek_resim_adi:String,
    var yemek_fiyat:Int,
    var yemek_siparis_adet:Int,
    var kullanci_adi:String) {
}