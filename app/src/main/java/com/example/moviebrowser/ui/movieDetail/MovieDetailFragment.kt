package com.example.moviebrowser.ui.movieDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.moviebrowser.bindingAdapter.ImageBinding
import com.example.moviebrowser.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class MovieDetailFragment : Fragment() {

    private val viewModel: MovieDetailViewModel by viewModels()
    private lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieDetailBinding.inflate(layoutInflater)
        binding.lifecycleOwner = viewLifecycleOwner

        setObservers()

        return binding.root

    }

    private fun setObservers() {
        viewModel.overView.observe(viewLifecycleOwner, Observer {
            binding.txtOverView.text = it
        })

        viewModel.imagePath.observe(viewLifecycleOwner, Observer {
            ImageBinding.bindImage(binding.imageView, it)
        })
    }


}