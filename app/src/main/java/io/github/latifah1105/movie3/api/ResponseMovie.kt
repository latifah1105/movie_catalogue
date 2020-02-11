package io.github.latifah1105.movie3.api

import io.github.latifah1105.movie3.model.Result

data class ResponseMovie(
    val page: Int,
    val results: ArrayList<Result>,
    val total_pages: Int,
    val total_results: Int
)