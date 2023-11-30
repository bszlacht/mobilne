package com.example.lab3and

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Flower::class), version=1)
abstract class FlowerDatabase: RoomDatabase() {
    abstract fun flowerDao(): FlowerDao
}