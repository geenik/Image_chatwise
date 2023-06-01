package com.example.image_chatwise

import com.example.image_chatwise.models.image
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object retrofithelper {

    private const val BASE_URL="https://jsonplaceholder.typicode.com/"
    fun getinstace():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}


