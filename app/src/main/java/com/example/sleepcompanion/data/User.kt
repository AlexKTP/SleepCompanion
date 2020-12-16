package com.example.sleepcompanion.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Entity annotation generates automatically a table
@Entity(tableName = "user_table")
data class User (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fistName: String,
    val lastName: String,
    val age: Int,
        )
