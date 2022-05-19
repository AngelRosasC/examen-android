package com.arcode.eamovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arcode.eamovies.R
import com.arcode.eamovies.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_EAMovies)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}