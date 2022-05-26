package com.example.moviebrowser.dataSource.repository

import android.util.Range
import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.dataSource.MoviesDataSource
import com.example.moviebrowser.repository.MovieRepository
import com.example.moviebrowser.utils.ApiStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class FakeRepository(private val dataSource: MoviesDataSource):MovieRepository {


    override suspend fun getTopRatedMovies(): Flow<ApiStatus<List<TopRatedMovies>>> = flow {

        val data=dataSource.getMoviesData() as MutableList<TopRatedMovies>


        emit(ApiStatus.Success(data))

    }
}