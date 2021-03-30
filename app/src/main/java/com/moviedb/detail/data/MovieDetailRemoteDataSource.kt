package com.moviedb.detail.data

import javax.inject.Inject

class MovieDetailRemoteDataSource @Inject constructor(
    private val movieDetailApiService: MovieDetailApiService
) {
    fun getMovieDetail(movieId: Int?) = movieDetailApiService.getMovieDetail(movieId)
}