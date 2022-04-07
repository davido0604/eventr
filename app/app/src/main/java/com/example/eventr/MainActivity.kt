package com.example.eventr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
        lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.searchMainFragment, R.id.profileFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.hide()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<LoginFragment>(R.id.fragmentContainerView)
        }
    }

    fun hideNavBar() {
        bottomNavigationView.visibility = View.GONE
    }

    fun showNavBar() {
        bottomNavigationView.visibility = View.VISIBLE
    }
}