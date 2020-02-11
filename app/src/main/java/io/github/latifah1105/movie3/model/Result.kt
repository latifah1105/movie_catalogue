package io.github.latifah1105.movie3.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    @SerializedName(value = "original_title", alternate = ["original_name"])
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    @SerializedName(value = "release_date", alternate = ["first_air_date"])
    val release_date: String,
    @SerializedName(value = "title", alternate = ["name"])
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable {

    fun getPosterUrl(): String {
        return "https://image.tmdb.org/t/p/w342/${poster_path}"
    }

}