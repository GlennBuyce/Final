/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
package com.example.watch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "titles_table")
data class TitlesTable(

    //entity class for the database and their parameters

    @PrimaryKey(autoGenerate = true)
    val tableIndex: Int = 0,

    @ColumnInfo(name = "Title")
    val title: String,

    @ColumnInfo(name = "IMDB id")
    val id: String,

    @ColumnInfo(name = "Image")
    val imageurl: String,

    @ColumnInfo(name = "Favorite")
    val favorite: Boolean,

    @ColumnInfo(name = "Watch")
    val watch: Boolean
    )

