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

    //database functions; error when setting insert to suspendable which doesn't allow for the database to work
    @Insert
    fun insert(titlesTable: TitlesTable)

    @Delete
    fun delete(titlesTable: TitlesTable)


    //these both would return a list of the titles in either list to then send to their fragments and populating them
    @Query("SELECT * FROM titles_table WHERE favorite = 1")
    fun getFavoritesList(): LiveData<List<TitlesTable>>

    @Query("SELECT * FROM titles_table WHERE watch = 1")
    fun getWatchList(): LiveData<List<TitlesTable>>

}