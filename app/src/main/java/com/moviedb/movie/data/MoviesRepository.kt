package com.moviedb.movie.data

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.moviedb.movie.data.res.Movie

interface MoviesRepository {
    fun getMoviesRemotePagingSource(query: String): LiveData<PagingData<Movie>>
}