package com.example.moviebrowser.network

import com.example.moviebrowser.dataModels.TopRatedMovies
import com.example.moviebrowser.dataModels.TopRatedMoviesList
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface RestApi {

    @GET("top_rated")
    fun getTopRatedMoviesListAsync(@Query("api_key") API_key:String)
    :Deferred<TopRatedMoviesList>

}

