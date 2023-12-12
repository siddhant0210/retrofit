package com.example.retrofit

import android.icu.text.CaseMap.Title
import com.google.gson.annotations.SerializedName

data class  AlbumItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userid : Int,
    @SerializedName("title")
    val title: String
)
