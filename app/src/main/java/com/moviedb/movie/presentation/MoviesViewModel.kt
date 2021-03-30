package com.moviedb.movie.presentation

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.m.base.ui.BaseViewModel
import com.moviedb.movie.data.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val moviesRepository: MoviesRepository
) : BaseViewModel() {

    private val currentQueryMutableLiveData = MutableLiveData<String>()

    val moviesLiveData = currentQueryMutableLiveData.switchMap { query ->
        moviesRepository.getMoviesRemotePagingSource(query).cachedIn(viewModelScope)
    }

    fun searchMovie(query: String) {
        currentQueryMutableLiveData.value = query
    }
}