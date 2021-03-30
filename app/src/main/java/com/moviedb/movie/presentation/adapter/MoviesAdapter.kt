package com.moviedb.movie.presentation.adapter

import android.view.View
import com.m.base.ui.*
import com.moviedb.R
import com.moviedb.databinding.MovieItemBinding
import com.moviedb.movie.data.res.Movie

class MoviesAdapter(private val clickListener: MoviesClickHandler): BaseAdapter<Movie, MovieItemBinding>(R.layout.movie_item) {
    override fun bindItem(binding: MovieItemBinding, item: Movie) {
        binding.item = item
    }

    override fun setClickListener(binding: MovieItemBinding): List<BaseAdapterClickListener> {
        return listOf((BaseAdapterClickListener(binding.root, object : BaseClickTask{
            override fun execute(view: View, position: Int) {
                clickListener.onMovieDetailOpen(binding)
            }


        })))
    }


}