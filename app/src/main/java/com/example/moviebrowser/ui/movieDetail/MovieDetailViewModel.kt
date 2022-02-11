package com.example.moviebrowser.ui.movieDetail

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.moviebrowser.dataModels.TopRatedMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) :
    ViewModel() {
    private val args = savedStateHandle.get<TopRatedMovies>("itemInView")

    private val _overView = MutableLiveData<String>()
    val overView: LiveData<String>
        get() = _overView
    private val _imagePath = MutableLiveData<String>()
    val imagePath: LiveData<String>
        get() = _imagePath

    init {
        _overView.value = args?.overview!!
        _imagePath.value = args.poster_path!!
    }

}