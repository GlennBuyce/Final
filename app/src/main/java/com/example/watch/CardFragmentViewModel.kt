/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */

package com.example.watch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CardFragmentViewModel(val dao: TitlesDao) : ViewModel() {


    //add title to database function; issue with making insert suspendable in database files
    fun addTitle(title: Result, favorite: Boolean, watch: Boolean){
        val titletext = title.titleText.text
        val image = title.primaryImage.url
        val id = title.id

        viewModelScope.launch {
            val title = TitlesTable(tableIndex = 0, titletext, id, image, favorite, watch)
            dao.insert(title)
        }

    }
}