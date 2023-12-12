package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface AlbumsService {
    @GET("/albums") // get is used for retrieving so creating a function for that
    suspend fun getAlbums(): Response<Albums> // response is a part of retrofit

}