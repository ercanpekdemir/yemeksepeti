package com.moviedb.detail.data

import com.moviedb.detail.data.res.MovieDetailResponse
import io.reactivex.Single

interface MovieDetailRepository {
    fun getMovieDetail(movieId: Int?) : Single<MovieDetailResponse>
}