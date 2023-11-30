package com.example.lab3and

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FlowerDao {
    @Insert
    fun insertAll(flower: Flower)

    @Delete
    fun delete(flower: Flower)

    @Query("SELECT * FROM flower")
    fun getAll(): List<Flower>

    @Query("SELECT * FROM flower WHERE flowerId IN (:flowerIds)")
    fun loadAllByIds(flowerIds: IntArray): List<Flower>
}