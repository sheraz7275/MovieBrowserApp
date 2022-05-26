package com.example.moviebrowser.dataSource.repository

import android.util.Log
import com.example.moviebrowser.dataSource.FakeDataSource
import com.example.moviebrowser.repository.DefaultMovieRepository
import com.example.moviebrowser.repository.MovieRepository
import com.example.moviebrowser.utils.ApiStatus
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class DefaultMovieRepository() {


   private lateinit var repository: MovieRepository


    private lateinit var fakeDataSource: FakeDataSource


    @Before
    fun setup() {
        fakeDataSource = FakeDataSource()
        repository = FakeRepository(fakeDataSource)
    }


    @Test
    fun testList() = runBlockingTest {

        val data = repository.getTopRatedMovies().first()


        when (data) {

            is ApiStatus.Success -> {
                val listSize=data.data.size
                assertThat(listSize).isEqualTo(10)
            }


        }
    }













}