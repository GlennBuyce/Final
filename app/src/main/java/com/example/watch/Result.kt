package com.example.watch

data class Result(
    val id: String,
    val position: Int,
    val primaryImage: PrimaryImage,
    val releaseDate: Any,
    val releaseYear: Any,
    val titleText: TitleText,
    val titleType: TitleType
)