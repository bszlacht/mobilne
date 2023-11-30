package com.example.bartoszszlachtaandroidlab1

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bartoszszlachtaandroidlab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setButtonsOnClickListener()
    }

//    private fun setButtonsOnClickListener() {
//        binding.btnNav1.setOnClickListener {
//            var intent = Intent(this, ActionsActivity::class.java)
//            startActivity(intent)
//        }
//    }
}