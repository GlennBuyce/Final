package com.example.watch

data class Data(
    val entries: Int,
    val next: String,
    val page: String,
    val results: List<Result>
)