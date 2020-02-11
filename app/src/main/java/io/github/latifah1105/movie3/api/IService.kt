package io.github.latifah1105.movie3.api

import retrofit2.Call
import retrofit2.http.GET

interface IService {

    @GET("movie/popular")
    fun getMovies() : Call<ResponseMovie>

    @GET("tv/popular")
    fun getTv() : Call<ResponseTvShow>

}