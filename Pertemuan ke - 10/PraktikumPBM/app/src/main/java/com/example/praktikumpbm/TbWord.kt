package com.example.praktikumpbm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="word_table")
data class TbWord(@PrimaryKey @ColumnInfo(name = "tbword")val tbword: String)

