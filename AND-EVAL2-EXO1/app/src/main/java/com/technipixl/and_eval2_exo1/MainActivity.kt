package com.technipixl.and_eval2_exo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technipixl.and_eval2_exo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}