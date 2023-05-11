package com.example.watch

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface API_Interface {
    @GET("titles/")
    @Headers("X-RapidAPI-Key:9ff43c858dmsh3fc29a0ee0e8e7ap18b24bjsn539d488bfbef", "X-RapidAPI-Host:moviesdatabase.p.rapidapi.com")
    fun getTitles(@Query("list") list: String?,
                  @Query("genre") genre: String?,
                  @Query("sort") sort: String?,
                  @Query("page") page: String?,
                  @Query("year") year: String?) : Call<Data?>?

    @GET("titles/")
    @Headers("X-RapidAPI-Key:9ff43c858dmsh3fc29a0ee0e8e7ap18b24bjsn539d488bfbef", "X-RapidAPI-Host:moviesdatabase.p.rapidapi.com")
    fun getMoreLikeThisTitles(@Query("info") info: String) : Call<ArrayList<TitlesTable?>?>?

    @GET("titles/")
    @Headers("X-RapidAPI-Key:9ff43c858dmsh3fc29a0ee0e8e7ap18b24bjsn539d488bfbef", "X-RapidAPI-Host:moviesdatabase.p.rapidapi.com")
    fun getTitleTest() : Call<Data?>?
    companion object {
        var BASE_URL = "https://moviesdatabase.p.rapidapi.com/"

        fun create() : API_Interface {

            val logging = HttpLoggingInterceptor()
// set your desired log level
// set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging) // <-- this is the important line!
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .build()
            return retrofit.create(API_Interface::class.java)
        }
    }
}