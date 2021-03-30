package com.moviedb.movie.presentation.adapter

import androidx.core.view.isVisible
import androidx.paging.LoadState
import com.m.base.ui.BaseAdapterClickListener
import com.m.base.ui.BaseLoadStateAdapter
import com.m.base.ui.BaseViewHolder
import com.moviedb.R
import com.moviedb.databinding.LoadStateFooterBinding

class MoviesStateAdapter(private val clickListener: MoviesClickHandler): BaseLoadStateAdapter<LoadStateFooterBinding>(R.layout.load_state_footer) {

    override fun onBindViewHolder(
        holder: BaseViewHolder<LoadStateFooterBinding>,
        loadState: LoadState
    ) {
        super.onBindViewHolder(holder, loadState)

        holder.binding.footerProgress.isVisible = loadState is LoadState.Loading
        holder.binding.loadRetry.isVisible = loadState !is LoadState.Loading
        holder.binding.txtError.isVisible = loadState !is LoadState.Loading
    }

    override fun setClickListener(binding: LoadStateFooterBinding): List<BaseAdapterClickListener> {
        binding.loadRetry.setOnClickListener {
            clickListener.onMovieLoadRetry()
        }
        return emptyList()
    }
}