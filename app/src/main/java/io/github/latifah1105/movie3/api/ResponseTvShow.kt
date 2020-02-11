package io.github.latifah1105.movie3.api

import io.github.latifah1105.movie3.model.Result

data class ResponseTvShow(
    val dates: Dates,
    val page: Int,
    val results: ArrayList<Result>,
    val total_pages: Int,
    val total_results: Int
)

data class Dates(
    val maximum: String,
    val minimum: String
)