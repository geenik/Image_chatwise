package com.example.image_chatwise

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.image_chatwise.models.image
import retrofit2.Response

class Repository(private val photoservice: photoapi) {
   private var  photdata=image()
   lateinit var resultphoto:Response<image>
    val Newsdata:image
          get()  = photdata
   suspend fun getphotos(){
       resultphoto=photoservice.getphotos()
       if(resultphoto?.body() != null){
        photdata=(resultphoto.body()!!)
       }
   }

}