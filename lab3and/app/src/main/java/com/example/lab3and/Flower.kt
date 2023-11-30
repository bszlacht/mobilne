package com.example.lab3and

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Flower(
    @PrimaryKey(autoGenerate = true) val flowerId: Int,
    @ColumnInfo(name = "polish_name") val polishName: String?,
    @ColumnInfo(name = "english_name") val englishName: String?
) {
    constructor(polishName: String?, englishName: String?) :
            this(0, polishName, englishName)
}
