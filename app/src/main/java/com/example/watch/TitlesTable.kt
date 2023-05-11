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

    @PrimaryKey(autoGenerate = true)
    var tableIndex: Int = 0,

    @ColumnInfo(name = "Title")
    var title: String,

    @ColumnInfo(name = "IMDB id")
    var id: String,

    @ColumnInfo(name = "Image")
    var imageurl: String,

    @ColumnInfo(name = "Favorite")
    var favorite: Boolean,

    @ColumnInfo(name = "Watch")
    var watch: Boolean
    )

