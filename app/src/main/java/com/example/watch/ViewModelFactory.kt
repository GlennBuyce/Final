/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
package com.example.watch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val dao: TitlesDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(CardFragmentViewModel::class.java)){
            return CardFragmentViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }

}