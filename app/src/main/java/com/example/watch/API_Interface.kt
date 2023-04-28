package com.example.watch

import android.icu.text.CaseMap
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers

interface API_Interface {
    @Headers("X-RapidAPI-Key", "9ff43c858dmsh3fc29a0ee0e8e7ap18b24bjsn539d488bfbef", "X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com", "content-type", "application/octet-stream")

    @GET("titles")
    fun getTitles() : Call<ArrayList<Titles?>?>? //MAKE A LIST FOR THESE

    companion object {
        var BASE_URL = "https://moviesdatabase.p.rapidapi.com/"

        fun create() : API_Interface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(API_Interface::class.java)
        }
    }
}