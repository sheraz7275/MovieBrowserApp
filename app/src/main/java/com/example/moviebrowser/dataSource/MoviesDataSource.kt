package com.example.moviebrowser.dataSource

import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.dataModels.TopRatedMoviesList

interface MoviesDataSource {
    suspend fun getMoviesData(): List<TopRatedMovies>?
}