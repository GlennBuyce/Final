/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
package com.example.watch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.watch.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    var list: String? = null
    var genre: String? = null
    var sort: String? = null
    var page: String? = null
    var year: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)



        _binding!!.search.setOnClickListener {

            list = when(_binding!!.listSpinner.selectedItem){
                    "Most Popular Movies" ->  "most_pop_movies"
                    "Most Popular Series" -> "most_pop_series"
                    "Top Box Office 200" -> "top_boxoffice_200"
                    "Top Box Office Last Week" -> "top_boxoffice_last_weekend_10"
                    "Top Rated 250" -> "top_rated_250"
                    "Lowest Rated 100" -> "top_rated_lowest_100"
                    "Top Rated Series" -> "top_rated_series_250"
                    else -> "BAD"
            }
            sort = when(_binding!!.sortSpinner.selectedItem){
                "Year Increasing" -> "year.incr"
                "Year Decreasing" -> "year.decr"
                else -> null
            }
            if(_binding!!.genreSpinner.selectedItem == "Genre"){
                genre = null
            }else{
                genre = _binding!!.genreSpinner.selectedItem as String?
            }

            page = _binding!!.yearEditText.text.toString()

            if(list == "BAD"){
                Toast.makeText(requireContext(), "Please choose a list", Toast.LENGTH_SHORT).show()
            }else{
                val action = SearchFragmentDirections.actionSearchFragmentToSearchResultFragment(list!!, genre, sort, page, year)
                //val action = SearchResultFragmentDirections.actionSearchResultFragmentToCardFragment(1)
                binding.root.findNavController().navigate(action)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}