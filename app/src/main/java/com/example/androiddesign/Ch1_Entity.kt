package com.example.androiddesign

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Ch1_Entity(
    @PrimaryKey(autoGenerate = true) // PrimaryKey 를 자동적으로 생성
    val id : Int,
    val number1 : String,
)
