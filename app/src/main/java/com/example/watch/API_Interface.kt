package com.example.watch

import android.icu.text.CaseMap
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface API_Interface {
    @Headers("X-RapidAPI-Key", "9ff43c858dmsh3fc29a0ee0e8e7ap18b24bjsn539d488bfbef", "X-RapidAPI-Host", "moviesdatabase.p.rapidapi.com", "content-type", "application/octet-stream")
    @GET("titles/")
    fun getTitles(@Query("list") list: String,
                  @Query("genre") genre: String?,
                  @Query("sort") sort: String?,
                  @Query("page") page: String?,
                  @Query("year") year: String?) : Call<ArrayList<Titles?>?>?

    fun getMoreLikeThisTitles(@Query("info") info: String) : Call<ArrayList<Titles?>?>?
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