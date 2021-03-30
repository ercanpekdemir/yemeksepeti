package com.moviedb.detail.data.res

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.m.base.network.BaseResponse
import kotlinx.android.parcel.Parcelize

data class MovieDetailResponse(
    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("genres")
    val genres: List<Genre>? = null
) : BaseResponse() {

    val attributionBackdropPath get() = "https://image.tmdb.org/t/p/original$backdropPath"
}

@Parcelize
data class Genre(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: Int? = null,
): Parcelable