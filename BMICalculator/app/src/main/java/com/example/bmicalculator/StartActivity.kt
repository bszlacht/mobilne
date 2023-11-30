package com.example.bmicalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.databinding.StartActivityBinding

class StartActivity : AppCompatActivity() {

    private lateinit var binding: StartActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StartActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}

