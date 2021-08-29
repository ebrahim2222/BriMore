package com.example.brikotlin.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.example.brikotlin.R
import com.example.brikotlin.databinding.SplashMainBinding
import com.example.brikotlin.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
@BindingAdapter("setImage")
fun setImage(view: View, url:String){
    val imageView = view as ImageView
    Glide.with(view).load(url).placeholder(R.drawable.profile).into(imageView)
}
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:SplashMainBinding = DataBindingUtil.setContentView(this,R.layout.splash_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
            val navController = navHostFragment.navController
            val appBarConfiguration = AppBarConfiguration(navController.graph)
            NavigationUI.setupWithNavController(binding.spToolbar,navController,appBarConfiguration)
            NavigationUI.setupWithNavController(binding.bottomNavView,navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.mainFragment) {
                binding.spToolbar.visibility = View.GONE
                binding.bottomNavView.visibility = View.VISIBLE
            } else if(destination.id == R.id.splashFragment) {
                binding.spToolbar.visibility = View.GONE
                binding.bottomNavView.visibility = View.GONE

            }else if(destination.id == R.id.categoriesFragment) {
                binding.spToolbar.visibility = View.VISIBLE
                binding.bottomNavView.visibility = View.GONE

            }else if(destination.id == R.id.subCategoryFragment) {
                binding.spToolbar.visibility = View.VISIBLE
                binding.bottomNavView.visibility = View.GONE

            }else if(destination.id == R.id.profileFragment) {
                binding.spToolbar.visibility = View.GONE
                binding.bottomNavView.visibility = View.VISIBLE


            }else if(destination.id == R.id.productDetailsFragment) {
                binding.spToolbar.visibility = View.GONE
                binding.bottomNavView.visibility = View.INVISIBLE

            }else if(destination.id == R.id.productDetailsFragment) {
                binding.spToolbar.visibility = View.GONE
                binding.bottomNavView.visibility = View.VISIBLE

            }
        }
    }
}