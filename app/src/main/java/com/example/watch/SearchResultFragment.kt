package com.example.watch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchResultFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var recycleAdapter: RecycleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        recycleAdapter = RecycleAdapter(requireContext(), Navigation.findNavController(view))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recycleAdapter

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