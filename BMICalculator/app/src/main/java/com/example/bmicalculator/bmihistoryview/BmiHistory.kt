package com.example.bmicalculator.bmihistoryview

import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class BmiHistory(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "weight") val weight: String?,
    @ColumnInfo(name = "height") val height: String?,
    @ColumnInfo(name = "bmi") val bmi: String?,
    @ColumnInfo(name = "date") val date: String?,
) {
    constructor(weight: String?, height: String?, bmi: String?, date: String?) :
            this(0, weight, height, bmi, date)
}
