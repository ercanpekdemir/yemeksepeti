package com.moviedb.detail.presentation

import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.m.base.ui.BaseViewModel
import com.moviedb.detail.data.res.MovieDetailResponse
import com.moviedb.detail.interactor.GetMovieDetail
import com.moviedb.detail.presentation.MovieDetailFragment.Companion.MOVIE_ARG
import com.moviedb.movie.data.res.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getMovieDetail: GetMovieDetail
) : BaseViewModel() {


    val progressObservable = ObservableField(View.GONE)
    val moveTitleObservable = ObservableField<String>()
    val moveOverviewObservable = ObservableField<String>()
    val moveGenresObservable = ObservableField<String>()
    val moveBackdropObservable = ObservableField<String>()

    val backMutableLiveData = MutableLiveData<Unit>()

    var movie: Movie? = null

    fun getMovieDetail(movieId: Int?) {
        getMovieDetail.execute(GetMovieDetailObserver(this), GetMovieDetail.Params(movieId))
    }

    fun parseArguments(arguments: Bundle?) {
        arguments?.apply {
            movie = getParcelable(MOVIE_ARG) as? Movie
        }
    }

    fun back() {
        backMutableLiveData.value = Unit
    }

    fun handleMovies(result: MovieDetailResponse) {
        moveOverviewObservable.set(result.overview)
        var genres = result.genres?.firstOrNull()?.name ?: ""
        val size = result.genres?.size ?: 0
        for(i in 1 until size) {
            genres = genres + " " + (result.genres?.elementAtOrNull(i)?.name ?: "")
        }
        moveGenresObservable.set(genres)
        if(result.backdropPath != null) {
            moveBackdropObservable.set(result.attributionBackdropPath)
        }
    }
}