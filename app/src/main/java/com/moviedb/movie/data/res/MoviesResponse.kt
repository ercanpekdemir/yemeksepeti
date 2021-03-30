package com.moviedb.movie.data.res

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.m.base.BaseResult
import com.m.base.network.BaseResponse
import com.m.base.ui.BaseItem
import kotlinx.android.parcel.Parcelize

data class MoviesResponse(
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null,
    @SerializedName("results")
    val results: List<Movie>? = null
): BaseResponse() {

    fun toViewData() = ViewData(page, totalPages, totalResults, results)

    @Parcelize
    data class ViewData(
        val page: Int? = null,
        val totalPages: Int? = null,
        val totalResults: Int? = null,
        val results: List<Movie>? = null
        ): BaseResult, Parcelable
}

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("vote_average")
    val voteAverage: Double? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,
): Parcelable, BaseItem<Movie> {

    val attributionPosterPath get() = "https://image.tmdb.org/t/p/w500$posterPath"
    val attributeVoteAverage get() = voteAverage?.toString() ?: ""

    override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
        oldItem == newItem
}