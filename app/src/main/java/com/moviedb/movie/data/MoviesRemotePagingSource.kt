package com.moviedb.movie.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.moviedb.movie.data.res.Movie
import retrofit2.HttpException
import java.io.IOException

private const val DEFAULT_INITIAL_PAGE = 1

class MoviesRemotePagingSource(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val query: String
): PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        try {
            val page = params.key ?: DEFAULT_INITIAL_PAGE
            val response = remoteDataSource.getMovies(query, page)
            val movies = response.results
            movies?.let { list ->
                return LoadResult.Page(
                    data = list,
                    prevKey = if(page == DEFAULT_INITIAL_PAGE) null else page - 1,
                    nextKey = if(list.isEmpty()) null else page + 1
                )
            }
        } catch (e: IOException) {
            return LoadResult.Error(e)
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        }

        return LoadResult.Error(Exception("Something wrong with result"))
    }
}