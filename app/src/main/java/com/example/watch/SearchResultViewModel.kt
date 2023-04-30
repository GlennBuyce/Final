package com.example.com.example.watch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.watch.API_Interface
import com.example.watch.Titles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchResultViewModel() : ViewModel(){

    var createTitlesLiveData: MutableLiveData<Titles?> = MutableLiveData()
    var title: Titles = Titles("title", "id", "image")

    fun getCreateTitlesLiveData(): MutableLiveData<Titles?>{
        return createTitlesLiveData
    }

    fun setLiveData(){
        createTitlesLiveData.value = title
    }

    fun getTitle(): String{
        return title.title
    }

    fun getId(): String{
        return title.id
    }

    fun getImage(): String {
        return title.imageurl
    }

    fun getTitlesAPI(){
        val API = API_Interface.create().getTitles()

        if(API != null){
            API.enqueue(object : Callback<ArrayList<Titles?>?> {
                override fun onResponse(
                    call: Call<ArrayList<Titles?>?>,
                    response: Response<ArrayList<Titles?>?>
                ) {
                    if (response?.body() != null){
                        recycleAdapter.setTitleListItems(response.body() !! as ArrayList<Titles>)
                    }
                }

                override fun onFailure(call: Call<ArrayList<Titles?>?>, t: Throwable) {
                    if (t != null) {
                        t.message?.let { Log.d("onFailure", it) }
                    }

                }
            })
        }
    }

}