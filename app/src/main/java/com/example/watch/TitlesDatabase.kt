/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
package com.example.watch

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TitlesTable::class], version = 1, exportSchema = false)
abstract class TitlesDatabase : RoomDatabase() {

    abstract val titlesDao: TitlesDao

    companion object {
        @Volatile
        private var INSTANCE: TitlesDatabase? = null

        fun getInstance(context: Context) : TitlesDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null){
                    instance  = Room.databaseBuilder(
                            context.applicationContext,
                            TitlesDatabase::class.java,
                            "titles_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}