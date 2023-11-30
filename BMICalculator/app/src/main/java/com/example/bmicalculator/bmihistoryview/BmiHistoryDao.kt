package com.example.bmicalculator.bmihistoryview

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BmiHistoryDao {
    @Insert
    fun insertAll(bmiHistory: BmiHistory)

    @Delete
    fun delete(bmiHistory: BmiHistory)

    @Query("SELECT * FROM bmiHistory")
    fun getAll(): List<BmiHistory>

    @Query("SELECT * FROM bmiHistory WHERE id IN (:bmiHistoryIds)")
    fun loadAllByIds(bmiHistoryIds: IntArray): List<BmiHistory>
}