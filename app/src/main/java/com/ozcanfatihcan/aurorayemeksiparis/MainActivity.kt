package com.ozcanfatihcan.aurorayemeksiparis

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ozcanfatihcan.aurorayemeksiparis.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        window.statusBarColor = getResources().getColor(R.color.toolBar)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.mainFragmentContainer) as NavHostFragment
        NavigationUI.setupWithNavController(binding.MainBottomNav,navHostFragment.navController)
    }
}