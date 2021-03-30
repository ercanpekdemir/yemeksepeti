package com.moviedb.detail.data

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailRemoteDataSourceTest {

    @Mock
    lateinit var movieDetailApiService: MovieDetailApiService

    @InjectMocks
    lateinit var remoteDataSource: MovieDetailRemoteDataSource

    @Test
    fun testGetMovieDetail() {
        // given
        val movieId = 674223
        // when
        remoteDataSource.getMovieDetail(movieId)
        //then
        Mockito.verify(movieDetailApiService).getMovieDetail(movieId)
    }
}