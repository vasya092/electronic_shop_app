package com.example.electronicshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.electronicshop.databinding.ActivityMainBinding
import com.example.electronicshop.ui.FilterBottomSheet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun getSupportFragmentManager(): FragmentManager {
        return super.getSupportFragmentManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment_content_main)
        val actionBar = binding.toolbarRoot.toolbarActionbar
        actionBar.title = ""
        setSupportActionBar(actionBar)
    }
    fun setLocationVisibility(visibility: Int) {
        binding.toolbarRoot.locationToolbar.visibility = visibility
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_filter -> {
                val modalBottomSheet = FilterBottomSheet()
                modalBottomSheet.show(supportFragmentManager, modalBottomSheet.tag)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}