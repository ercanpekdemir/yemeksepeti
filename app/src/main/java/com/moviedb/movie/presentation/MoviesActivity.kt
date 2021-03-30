package com.moviedb.movie.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING
import com.m.base.ui.BaseActivity
import com.moviedb.R
import com.moviedb.databinding.ActivityMoviesBinding
import com.moviedb.databinding.MovieItemBinding
import com.moviedb.detail.presentation.MovieDetailFragment
import com.moviedb.movie.presentation.adapter.MoviesAdapter
import com.moviedb.movie.presentation.adapter.MoviesClickHandler
import com.moviedb.movie.presentation.adapter.MoviesStateAdapter
import com.moviedb.util.hideKeyboard
import com.moviedb.util.onTextUpdated
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : BaseActivity<MoviesViewModel, ActivityMoviesBinding>(), MoviesClickHandler {

    private val viewModel: MoviesViewModel by viewModels()
    private val moviesAdapter = MoviesAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setRecyclerView()

        observeLiveData()

        handleTextInput()
    }

    private fun handleTextInput() {
        binding.search.onTextUpdated { input ->
            viewModel.searchMovie(input)
        }
    }

    private fun observeLiveData() {
        viewModel.moviesLiveData.observe(this) {
            moviesAdapter.submitData(lifecycle, it)
        }
    }

    private fun setRecyclerView() {
        binding.recyclerview.apply {
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if(newState == SCROLL_STATE_DRAGGING) {
                        binding.search.hideKeyboard()
                    }
                }
            })
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this@MoviesActivity,3)
            adapter = moviesAdapter.withLoadStateHeaderAndFooter(
                header = MoviesStateAdapter(this@MoviesActivity),
                footer = MoviesStateAdapter(this@MoviesActivity)
            )
        }
    }


    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun provideLayoutResId() = R.layout.activity_movies



    override fun onMovieLoadRetry() {
        moviesAdapter.retry()
    }

    override fun onMovieDetailOpen(binding: ViewDataBinding) {
        binding.root.hideKeyboard()
        val movieItemBinding = binding as? MovieItemBinding
        MovieDetailFragment.newInstance(movieItemBinding?.item).show(supportFragmentManager, MovieDetailFragment.TAG)
    }

    override fun bindViewModel(db: ActivityMoviesBinding): MoviesViewModel {
        return viewModel.apply {
            binding.viewModel = this
        }
    }
}