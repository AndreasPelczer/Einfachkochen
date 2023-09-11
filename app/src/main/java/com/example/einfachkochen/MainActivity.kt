package com.example.einfachkochen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.einfachkochen.databinding.ActivityMainBinding
import com.example.einfachkochen.ui.VideoFragmentDirections

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.favorite -> {

                    val navController = findNavController(R.id.navHostFragment)
                    val currentDestination = navController.currentDestination

                     if (currentDestination?.id == R.id.homeFragment){
                        val action = HomeFragmentDirections.actionHomeFragmentToFavoritFragment()
                        navController.navigate(action)

                    } else if ( currentDestination?.id == R.id.videoFragment) {
                        val action = VideoFragmentDirections.actionVideoFragmentToFavoritFragment()
                        navController.navigate(action)
                    }
                    true
                }

                R.id.video -> {

                    val navController = findNavController(R.id.navHostFragment)
                    val currentDestination = navController.currentDestination

                    if (currentDestination?.id == R.id.favoritFragment) {
                        val action = FavoritFragmentDirections.actionFavoritFragmentToVideoFragment()
                        navController.navigate(action)

                    } else if (currentDestination?.id == R.id.homeFragment) {
                        val action = HomeFragmentDirections.actionHomeFragmentToVideoFragment()
                        navController.navigate(action)

                    }

                    true

                }

                R.id.home -> {
                    // Navigiere auf item klick zum homefragment.//
                    val navController = findNavController(R.id.navHostFragment)
                    val currentDestination = navController.currentDestination

                    if (currentDestination?.id == R.id.detailFragment) {
                        val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
                        navController.navigate(action)

                    } else if (currentDestination?.id == R.id.favoritFragment) {
                        val action = FavoritFragmentDirections.actionFavoritFragmentToHomeFragment()
                        navController.navigate(action)

                    } else if (currentDestination?.id == R.id.videoFragment){
                        val action = VideoFragmentDirections.actionVideoFragmentToHomeFragment()
                        navController.navigate(action)
                    }

                    true
                }

                else -> {
                    // Standard-Navigation zu anderen Fragmenten
                    NavigationUI.onNavDestinationSelected(item, navController)
                    navController.popBackStack(item.itemId, false)
                    true
                }
            }
        }
    }
}