package com.example.praktikumpbm

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface TbWordDAO {
    @Query("SELECT * from word_table ORDER BY tbword ASC")
    fun getAlphabetizedWords(): LiveData<List<TbWord>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tbword: TbWord)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}