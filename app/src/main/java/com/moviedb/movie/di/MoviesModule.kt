package com.moviedb.movie.di

import com.m.base.network.BaseRetrofit
import com.moviedb.movie.data.MoviesApiService
import com.moviedb.movie.data.MoviesDataRepository
import com.moviedb.movie.data.MoviesRemoteDataSource
import com.moviedb.movie.data.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object MoviesModule {
    @ViewModelScoped
    @Provides
    fun provideSearchMovieRemoteDataSource(baseRetrofit: BaseRetrofit): MoviesRemoteDataSource =
        MoviesRemoteDataSource(baseRetrofit.create(MoviesApiService::class.java))

    @ViewModelScoped
    @Provides
    fun provideSearchMovieDataRepository(remoteDataSource: MoviesRemoteDataSource): MoviesRepository =
        MoviesDataRepository(remoteDataSource)
}