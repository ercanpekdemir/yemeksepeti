package com.moviedb.detail.data

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailDataRepositoryTest {
    @Mock
    lateinit var movieDetailRemoteDataSource: MovieDetailRemoteDataSource

    @InjectMocks
    lateinit var repository: MovieDetailDataRepository

    @Test
    fun testGetMovieDetail() {
        // given
        val movieId = 674223
        // when
        repository.getMovieDetail(movieId)
        //then
        Mockito.verify(movieDetailRemoteDataSource).getMovieDetail(movieId)
    }
}