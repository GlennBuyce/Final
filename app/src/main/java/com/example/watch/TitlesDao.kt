/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
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
    fun getFavoritesList(): List<TitlesTable>

    @Query("SELECT * FROM titles_table WHERE watch = 1")
    fun getWatchList(): List<TitlesTable>

}