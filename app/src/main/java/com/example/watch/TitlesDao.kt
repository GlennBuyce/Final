package com.example.watch

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TitlesDao {

    @Insert
    fun insert(titlesTable: TitlesTable)

    @Delete
    fun delete(titlesTable: TitlesTable)

    @Query("SELECT * FROM titles_table WHERE favorite = 1")
    fun getFavoritesList(): LiveData<ArrayList<TitlesTable>>

    @Query("SELECT * FROM titles_table WHERE watch = 1")
    fun getWatchList(): LiveData<ArrayList<TitlesTable>>

}