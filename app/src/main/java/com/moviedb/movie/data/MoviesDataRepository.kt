package com.moviedb.movie.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import javax.inject.Inject

class MoviesDataRepository @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource
): MoviesRepository {

    override fun getMoviesRemotePagingSource(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 15,
                maxSize = 60,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { MoviesRemotePagingSource(remoteDataSource, query) }
        ).liveData
}