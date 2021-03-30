package com.moviedb.detail.data

import javax.inject.Inject

class MovieDetailDataRepository @Inject constructor(
    private val movieDetailRemoteDataSource: MovieDetailRemoteDataSource
): MovieDetailRepository {
    override fun getMovieDetail(movieId: Int?) = movieDetailRemoteDataSource.getMovieDetail(movieId)
}