package com.example.starwarsmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.starwarsmvp.databinding.ActivityMainBinding
import com.example.starwarsmvp.di.StarWarsApp

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        StarWarsApp.starWarsComponent.inject(this)

        val navController = supportFragmentManager.findFragmentById(R.id.frag_container) as NavHostFragment

        binding.starWarsBt.setupWithNavController(navController.navController)
    }
}