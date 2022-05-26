package com.example.moviebrowser.ui.movieListimport androidx.lifecycle.ViewModelimport androidx.lifecycle.viewModelScopeimport com.example.moviebrowser.dataModels.TopRatedMoviesimport com.example.moviebrowser.repository.MovieRepositoryimport com.example.moviebrowser.utils.ApiStatusimport dagger.hilt.android.lifecycle.HiltViewModelimport kotlinx.coroutines.flow.MutableStateFlowimport kotlinx.coroutines.flow.asSharedFlowimport kotlinx.coroutines.flow.asStateFlowimport kotlinx.coroutines.flow.collectimport kotlinx.coroutines.launchimport javax.inject.Inject@HiltViewModelclass MovieListViewModel @Inject constructor(private val repositoryDefault: MovieRepository) :    ViewModel() {    // Encapsulation of data with stat flow    private val _topRatedMoviesList = MutableStateFlow<List<TopRatedMovies>?>(null)    val topRatedMoviesList=_topRatedMoviesList.asStateFlow()    private val _error = MutableStateFlow<String?>(null)    val error = _error.asSharedFlow()    private var topRatedMoviesUnmodified = mutableListOf<TopRatedMovies>()    init {        apiCall()    }    // function responsible for API call    private fun apiCall() {        viewModelScope.launch {            repositoryDefault.getTopRatedMovies().collect {                when(it){                    is ApiStatus.Success ->{                        _topRatedMoviesList.value=it.data                    }                    is ApiStatus.Error->{                        _error.value=it.exception.toString()                    }                }            }        }    }    /*// setting data upon receiving    private suspend fun setData() {        if (_topRatedMoviesList.value.isNullOrEmpty()){            return        }        topRatedMoviesUnmodified = _topRatedMoviesList.value as MutableList<TopRatedMovies>    }*/    // filtration of data on search query    fun filterList(searchQuery: String?) {        val processingList = topRatedMoviesUnmodified        var resultList = mutableListOf<TopRatedMovies>()        if (searchQuery != null) {            if (searchQuery.isNotEmpty()) {                for (movie in processingList) {                    if (movie.title?.lowercase()?.contains(searchQuery.lowercase()) == true) {                        resultList.add(movie)                        submitFilterData(resultList)                    } else {                        submitFilterData(resultList)                    }                }            } else {                resultList.clear()                resultList = topRatedMoviesUnmodified                submitFilterData(resultList)            }        }    }    private fun submitFilterData(finalData: MutableList<TopRatedMovies>) {        _topRatedMoviesList.value = finalData    }}