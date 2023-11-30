package com.example.lab3and

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.lab3and.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bnd: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bnd = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bnd.root)

        val db = Room.databaseBuilder(
            applicationContext,
            FlowerDatabase::class.java, "flowerdatabase"
        ).allowMainThreadQueries().enableMultiInstanceInvalidation()
            .fallbackToDestructiveMigration().build()
        val flowerDao = db.flowerDao()
        val flower = Flower(
            polishName = "Aasdsad", englishName = "Aasdsad"
        )

        val flowerData = flowerDao.getAll()
        val flowerAdapter = FlowerAdapter(flowerData)
        val recycleView: RecyclerView = bnd.ryFlower
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = flowerAdapter

        flowerDao.insertAll(flower)

        val flowers: List<Flower> = flowerDao.getAll()
        for (flower in flowers) {
            Log.i("FlowerApp", flower.toString())
        }
    }
}