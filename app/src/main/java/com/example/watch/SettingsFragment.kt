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
import com.example.watch.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //each button is initialized here; they would clear the database of any title with the relevant boolean set to true
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        _binding!!.ClearFavorites.setOnClickListener {

        }
        _binding!!.ClearWatch.setOnClickListener {

        }
        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}