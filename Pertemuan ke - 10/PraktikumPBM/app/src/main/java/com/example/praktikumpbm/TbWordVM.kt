package com.example.praktikumpbm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TbWordVM(application: Application) : AndroidViewModel(application) {
    private val repository: TbWordRepository
    val allWords: LiveData<List<TbWord>>

    init {
        val tbworddao = TbWordRmDatabase.getDatabase(application, viewModelScope).tbwordDao()
        repository = TbWordRepository(tbworddao)
        allWords = repository.allWords
    }

    fun insert(tbword: TbWord) = viewModelScope.launch {
        repository.insert(tbword)
    }
}