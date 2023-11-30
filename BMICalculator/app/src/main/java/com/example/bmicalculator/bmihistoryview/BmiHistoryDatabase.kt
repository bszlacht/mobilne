package com.example.bmicalculator.bmihistoryview

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BmiHistory::class), version = 2)
abstract class BmiHistoryDatabase: RoomDatabase() {
    abstract fun bmiHistoryDao(): BmiHistoryDao
}