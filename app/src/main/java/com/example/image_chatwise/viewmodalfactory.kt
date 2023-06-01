package com.example.image_chatwise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(mainviewmodel::class.java)) {
            return mainviewmodel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
