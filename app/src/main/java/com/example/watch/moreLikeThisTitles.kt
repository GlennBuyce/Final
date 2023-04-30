package com.example.watch

data class moreLikeThisTitles(
    val entries: Int,
    val next: String,
    val page: Int,
    val results: List<ResultX>
)