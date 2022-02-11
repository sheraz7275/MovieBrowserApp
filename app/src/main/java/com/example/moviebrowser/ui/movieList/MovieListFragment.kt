package com.example.moviebrowser.ui.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.moviebrowser.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
@FragmentScoped
class MovieListFragment : Fragment() {

    private val viewModel: MovieListViewModel by viewModels()

    private lateinit var binding: FragmentMovieListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding= FragmentMovieListBinding.inflate(layoutInflater)

        binding.lifecycleOwner = viewLifecycleOwner

        setObservers()

        searchViewListenerImplementation()

        return binding.root

    }


    private fun setObservers(){

        lifecycleScope.launch {
            viewModel.topRatedMoviesList.flowWithLifecycle(lifecycle).collect(){
                binding.recMovies.adapter= it?.let { it1 -> MoviesListAdapter(it1) }
            }
        }

        lifecycleScope.launch {
            viewModel.status.flowWithLifecycle(lifecycle).collect {
                Toast.makeText(requireContext(),it,Toast.LENGTH_SHORT).show()
            }
        }


    }


    private fun searchViewListenerImplementation(){
        binding.editSearchView.setOnQueryTextListener(object : OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
               viewModel.filterList(newText)

                return false
            }
        })
    }


}