package com.arcode.eamovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arcode.eamovies.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_EAMovies)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}