/*
Glenn Buyce
May 2023
SER210 Final Project
Watch
 */
package com.example.watch

import android.app.Application

class TitlesApplication: Application() {
    val database: TitlesDatabase by lazy {TitlesDatabase.getInstance(this)}
}