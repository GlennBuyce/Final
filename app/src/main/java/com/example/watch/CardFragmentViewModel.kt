package com.example.watch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CardFragmentViewModel(val dao: TitlesDao) : ViewModel() {

    fun addTitle(){
        viewModelScope.launch {
            val title = TitlesTable()
            title.id =
        }
    }

}