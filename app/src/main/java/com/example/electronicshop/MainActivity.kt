package com.example.electronicshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
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
        binding.toolbarRoot.toolbarActionbar.setupWithNavController(navController)

        val menuItemFilter = binding.toolbarRoot.toolbarActionbar.menu.findItem(R.id.action_filter)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.homeFragment) {
                binding.toolbarRoot.selectLocationWrapper.visibility = View.VISIBLE
                menuItemFilter.isVisible = true
            } else {
                binding.toolbarWrapper.visibility = View.VISIBLE
                binding.toolbarRoot.selectLocationWrapper.visibility = View.GONE
                menuItemFilter.isVisible = false
            }
        }

        menuItemFilter.setOnMenuItemClickListener {
            val modalBottomSheet = FilterBottomSheet()
            modalBottomSheet.show(supportFragmentManager, modalBottomSheet.tag)
            true
        }

        binding.toolbarRoot.toolbarActionbar.title = ""

        hideSystemUI()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
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