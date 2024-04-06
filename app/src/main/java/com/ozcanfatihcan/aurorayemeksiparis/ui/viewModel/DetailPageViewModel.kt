package com.ozcanfatihcan.aurorayemeksiparis.ui.viewModel

import android.view.View
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModel
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.FoodRepository
import com.ozcanfatihcan.aurorayemeksiparis.data.repo.ShopCartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.time.times

@HiltViewModel
class DetailPageViewModel @Inject constructor (var foodRepository: FoodRepository,var shopCartRepository: ShopCartRepository): ViewModel() {
    var count=0
   fun pieceStatusControl(buttonType:String,textPiece: TextView, textTotal:TextView, price:Int)
    {
       if (buttonType=="+"){
           count++
           textPiece.text=count.toString()
           textTotal.text="${(price*count)} ₺"
       }else{
           if (count>0){
               count--
               textPiece.text=count.toString()
               if ((price*count)!=0){
                   textTotal.text="${(price*count)} ₺"
               }else{
                   textTotal.text="0.00 ₺"
               }
           }
       }
    }

}