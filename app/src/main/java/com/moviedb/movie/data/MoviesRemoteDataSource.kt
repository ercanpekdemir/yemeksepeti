package com.moviedb.movie.data

import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val service: MoviesApiService
) {
    suspend fun getMovies(query: String?, page: Int?) = service.getMovies(query, page)
}
