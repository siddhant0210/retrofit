package com.example.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{   // used for static keyword
         val mainUrl = "https://jsonplaceholder.typicode.com/"

        // create a get retrofit instance function

        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(mainUrl)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }
}