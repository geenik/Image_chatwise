package com.example.image_chatwise

import com.example.image_chatwise.models.image
import retrofit2.Response
import retrofit2.http.GET

interface photoapi {
    @GET("photos")
   suspend fun getphotos():Response<image>
}