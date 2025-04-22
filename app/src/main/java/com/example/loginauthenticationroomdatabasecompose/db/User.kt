package com.example.loginauthenticationroomdatabasecompose.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "users")
data class User(
    @PrimaryKey val username: String,
    val password: String
)

@Entity(tableName = "data_table")
data class DataEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val date: Date,
    val image: String
)
