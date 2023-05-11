package com.example.watch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.com.example.watch.SearchResultViewModel
import com.example.watch.databinding.FragmentSearchResultBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchResultFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var recycleAdapter: RecycleAdapter
    private var _binding: FragmentSearchResultBinding? = null
    private val binding get() = _binding!!

    var list : String? = null
    var genre : String? = null
    var sort : String? = null
    var page : String? = null
    var year : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if(bundle == null){
            Log.e("SearchResultFragment", "SearchResultFragment did not receive data")
            return
        }
        list = SearchResultFragmentArgs.fromBundle(bundle).list
        genre = SearchResultFragmentArgs.fromBundle(bundle).genre
        sort = SearchResultFragmentArgs.fromBundle(bundle).sort
        page = SearchResultFragmentArgs.fromBundle(bundle).page
        year = SearchResultFragmentArgs.fromBundle(bundle).year
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview)
        recycleAdapter = RecycleAdapter(requireContext(), Navigation.findNavController(view))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recycleAdapter

        val apiInterface = API_Interface.create().getTitles(list, genre, sort, page, year)

        if (apiInterface != null) {
            apiInterface.enqueue( object : Callback<Data?> {
                override fun onResponse(call: Call<Data?>?, response: Response<Data?>) {
                    if (response != null) {
                        Log.d("Main activity", response.body().toString())
                    }
                    if(response?.body() != null){
                        var titles:Data = response.body() as Data
                        recycleAdapter.setTitleListItems(titles)
                    }
                }
                override fun onFailure(call: Call<Data?>, t: Throwable) {
                    if (t != null) {

                        t.message?.let { Log.d("onFailure", it) }
                    }
                }
            })
        }
    }
}