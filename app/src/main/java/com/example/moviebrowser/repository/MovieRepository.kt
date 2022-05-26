package com.example.moviebrowser.repository

import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.utils.ApiStatus
import kotlinx.coroutines.flow.Flow

interface MovieRepository{

    suspend fun getTopRatedMovies(): Flow<ApiStatus<List<TopRatedMovies>>>
}