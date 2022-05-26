package com.example.moviebrowser.dataSource.remote

import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.dataSource.MoviesDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val restApi: RestApi):MoviesDataSource {
    private val API_KEY = "8dd6c8345c87851c0364e4c299299bbe"

    override suspend fun getMoviesData(): List<TopRatedMovies>? {
        return restApi.getTopRatedMoviesListAsync(API_KEY).await().results
    }

}