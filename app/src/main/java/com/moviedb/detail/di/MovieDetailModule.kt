package com.moviedb.detail.di

import com.m.base.network.BaseRetrofit
import com.moviedb.detail.data.MovieDetailApiService
import com.moviedb.detail.data.MovieDetailDataRepository
import com.moviedb.detail.data.MovieDetailRemoteDataSource
import com.moviedb.detail.data.MovieDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MovieDetailModule {
    @ViewModelScoped
    @Provides
    fun provideMovieDetailRemoteDataSource(baseRetrofit: BaseRetrofit): MovieDetailRemoteDataSource =
        MovieDetailRemoteDataSource(baseRetrofit.create(MovieDetailApiService::class.java))

    @ViewModelScoped
    @Provides
    fun provideMovieDetailDataRepository(remoteDataSource: MovieDetailRemoteDataSource): MovieDetailRepository = MovieDetailDataRepository(remoteDataSource)
}