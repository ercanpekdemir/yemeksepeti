package com.moviedb.movie.data

import com.moviedb.BuildConfig
import com.moviedb.movie.data.res.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
//    https://image.tmdb.org/t/p/w500

    @GET("search/movie?api_key="+BuildConfig.API_KEY)
    suspend fun getMovies(@Query("query") query: String?, @Query("page") page: Int?) : MoviesResponse
}