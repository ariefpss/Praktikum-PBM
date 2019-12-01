package com.example.praktikumpbm

import androidx.lifecycle.LiveData

class TbWordRepository (private val tbWordDao: TbWordDAO) {
    val allWords: LiveData<List<TbWord>> = tbWordDao.getAlphabetizedWords()
    suspend fun insert(word: TbWord) {
        tbWordDao.insert(word)
    }
}