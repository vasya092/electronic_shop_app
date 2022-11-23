package com.example.electronicshop

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.electronicshop.databinding.ActivityMainBinding
import com.example.electronicshop.ui.FilterBottomSheet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment_content_main)
        val actionBar = binding.toolbarRoot.toolbarActionbar
        setSupportActionBar(actionBar)
//        binding.toolbarRoot.toolbarActionbar.setupWithNavController(navController)

        handleToolbarButtons(binding)
        hideSystemUI()

    }
    fun setHomeToolbarVisibility(visibility: Int) {
        binding.toolbarRoot.locationToolbar.visibility = visibility
    }

    fun setDetailToolbarVisibility(visibility: Int) {
        binding.toolbarRoot.detailToolbar.visibility = visibility
    }

    fun setCartToolbarVisibility(visibility: Int) {
        binding.toolbarRoot.cartToolbar.visibility = visibility
    }

    private fun handleToolbarButtons(binding: ActivityMainBinding) {
        binding.toolbarRoot.toolbarButtonFilter.setOnClickListener{
            val modalBottomSheet = FilterBottomSheet()
            modalBottomSheet.show(supportFragmentManager, modalBottomSheet.tag)
        }
        binding.toolbarRoot.toolbarBack.setOnClickListener{
            navController.navigate(R.id.action_detailFragment_to_homeFragment)
        }
        binding.toolbarRoot.cartToolbarBack.setOnClickListener{
            navController.navigate(R.id.action_cartFragment_to_detailFragment)
        }
        binding.toolbarRoot.toolbarCart.setOnClickListener{
            navController.navigate(R.id.action_detailFragment_to_cartFragment)
        }
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(android.R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}