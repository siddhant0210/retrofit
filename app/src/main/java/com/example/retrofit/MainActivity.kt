package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // initializing retrofit service
        val retrofitService = RetrofitInstance.getRetrofitInstance().create(AlbumsService ::class.java)

        val responseLiveData : LiveData<Response<Albums>> =
            liveData {
                val response = retrofitService.getAlbums() // handling the data
                emit(response) // send the response
            }

        // observing the data

        responseLiveData.observe(this , Observer {
            val albumList = it.body()?.listIterator()
            if(albumList != null){
                while(albumList.hasNext()){
                    val albumItem = albumList.next()

                    val albumTitle = "Album Title: ${albumItem.title} \n"
                    binding.titleTextView.append(albumTitle)
                }
            }
        })
    }
}