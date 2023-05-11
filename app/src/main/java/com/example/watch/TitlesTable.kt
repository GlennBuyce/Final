package com.example.watch

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "titles_table")
data class TitlesTable(

    @PrimaryKey(autoGenerate = true)
    var tableIndex: Long = 0L,

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
//self made not from plugin, may use to consolidate from other data classes... maybe for Dao
