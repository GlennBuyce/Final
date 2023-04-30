package com.example.watch

data class Node(
    val __typename: String,
    val canHaveEpisodes: Boolean,
    val canRate: CanRate,
    val certificate: Certificate,
    val id: String,
    val originalTitleText: OriginalTitleText,
    val primaryImage: PrimaryImageX,
    val primaryWatchOption: PrimaryWatchOption,
    val ratingsSummary: RatingsSummary,
    val releaseYear: ReleaseYear,
    val runtime: Runtime,
    val titleText: TitleTextX,
    val titleType: TitleTypeX
)