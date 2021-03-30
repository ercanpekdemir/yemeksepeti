package com.moviedb.detail.interactor

import com.m.base.BaseUseCase
import com.moviedb.detail.data.MovieDetailRepository
import com.moviedb.detail.data.res.MovieDetailResponse
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetMovieDetail @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository
): BaseUseCase<MovieDetailResponse, GetMovieDetail.Params>(){

    override fun buildUseCaseObservable(params: Params) =
        movieDetailRepository.getMovieDetail(params.movieId)

    data class Params(val movieId: Int?)
}