package com.moviedb.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.m.base.ui.BaseFragment
import com.moviedb.R
import com.moviedb.components.circularcountdown.CircularCountDownViewHandler
import com.moviedb.databinding.FragmentDetailBinding
import com.moviedb.detail.interactor.GetMovieDetail
import com.moviedb.movie.data.res.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment: BaseFragment<MovieDetailViewModel, FragmentDetailBinding>(), CircularCountDownViewHandler {

    companion object {
        const val TAG = "MovieDetailFragment"
        const val MOVIE_ARG = "movieArg"

        fun newInstance(movie: Movie?) = MovieDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(MOVIE_ARG, movie)
            }
        }
    }

    private val viewModel: MovieDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        viewModel.parseArguments(arguments)

        viewModel.moveTitleObservable.set(viewModel.movie?.title)

        viewModel.backMutableLiveData.observeForever {
            dismiss()
        }

        viewModel.getMovieDetail(GetMovieDetailObserver(viewModel) ,GetMovieDetail.Params(viewModel.movie?.id))

        binding.countdown.setHandler(this)

        return view
    }

    override fun provideLayoutResId() = R.layout.fragment_detail

    override fun bindViewModel(db: FragmentDetailBinding): MovieDetailViewModel {
        return viewModel.apply {
            db.viewModel = this
        }
    }

    override fun showLoading() {
        viewModel.progressObservable.set(View.VISIBLE)
    }

    override fun hideLoading() {
        viewModel.progressObservable.set(View.GONE)
    }

    override fun handleClick() {
        println("hobaaaaaaaaaaa")
    }
}