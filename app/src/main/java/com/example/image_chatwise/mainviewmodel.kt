package com.example.image_chatwise

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.image_chatwise.models.image
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class mainviewmodel(private val repository:Repository):ViewModel() {
    lateinit var photodata:image
   suspend fun fetchphoto(){
        GlobalScope.async {
            repository.getphotos()
        }.await()
        photodata=repository.Newsdata
    }
}