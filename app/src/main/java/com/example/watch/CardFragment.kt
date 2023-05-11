/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
package com.example.watch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.watch.databinding.FragmentCardBinding


class CardFragment : Fragment() {

    private val viewModel: CardFragmentViewModel by activityViewModels {
        ViewModelFactory((activity?.application as TitlesApplication).database.titlesDao)
    }
    var title_id : Int = 0
    private var _binding: FragmentCardBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if(bundle == null){
            Log.e("Card Fragment", "Card Fragment did not recieve id")
            return
        }
        title_id = CardFragmentArgs.fromBundle(bundle).titleId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val dao = TitlesDatabase.getInstance(application).titlesDao
        //val viewModelFactory = ViewModelFactory(dao)
        //val viewModel = ViewModelProvider(
        //    this, viewModelFactory).get(CardFragmentViewModel::class.java)
        //binding.viewModel = viewModel
        //binding.lifecycleOwner = viewLifecycleOwner
        _binding!!.addToFavorite.setOnClickListener {
            viewModel.addTitle(titleList[title_id], true, false)
        }
        _binding!!.addToWatch.setOnClickListener {
            viewModel.addTitle(titleList[title_id], false, true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.itemTitle.text = titleList[title_id].titleText.text
        Glide.with(requireContext()).load(titleList[title_id].primaryImage.url)
            .apply(RequestOptions().centerCrop())
            .into(binding.itemImage)
    }
}