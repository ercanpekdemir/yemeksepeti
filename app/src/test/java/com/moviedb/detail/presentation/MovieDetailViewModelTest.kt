package com.moviedb.detail.presentation

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.moviedb.detail.data.res.MovieDetailResponse
import com.moviedb.detail.interactor.GetMovieDetail
import com.moviedb.movie.data.res.Movie
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    @Mock
    lateinit var getMovieDetail: GetMovieDetail

    @Mock
    lateinit var observer: GetMovieDetailObserver

    @Mock
    lateinit var param: GetMovieDetail.Params

    @InjectMocks
    lateinit var viewModel: MovieDetailViewModel

    @Test
    fun getMovieDetail() {
        // given
        val movieId = 674223
        // when
        viewModel.getMovieDetail(observer, param)
        // then
        verify(getMovieDetail).execute(observer, param)
    }

    @Test
    fun parseArguments() {
        // given
        val data = Movie()
        val bundle = Mockito.mock(Bundle::class.java)
        // when
        Mockito.`when`(bundle.getParcelable<Movie>(MovieDetailFragment.MOVIE_ARG)).thenReturn(data)
        viewModel.parseArguments(bundle)
        // then
        assertEquals(viewModel.movie, data)
    }

    @Test
    fun handleMovies() {
        // given
        val res = MovieDetailResponse(overview = "txt")
        // when
        viewModel.handleMovies(res)
        // then
        assertEquals(viewModel.moveOverviewObservable.get(), "txt")
    }
}