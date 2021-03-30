package com.moviedb.detail.presentation

import com.moviedb.detail.data.res.MovieDetailResponse
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetMovieDetailObserverTest {

    @Mock
    lateinit var viewModel: MovieDetailViewModel

    @InjectMocks
    lateinit var observer: GetMovieDetailObserver

    @Test
    fun onResultSuccess() {
        // given
        val response = mock(MovieDetailResponse::class.java)
        // when
        observer.onResultSuccess(response)
        // then
        verify(viewModel).handleMovies(response)
    }

    @Test
    fun onResultFail() {
    }
}