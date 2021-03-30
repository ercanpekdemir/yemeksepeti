package com.moviedb.detail.data

import com.moviedb.detail.data.res.MovieDetailResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailApiService {

    @GET("movie/{movie_id}?api_key=35ef0461fc4557cf1d256d3335ed7545")
    fun getMovieDetail(@Path("movie_id") movieId: Int?) : Single<MovieDetailResponse>

}