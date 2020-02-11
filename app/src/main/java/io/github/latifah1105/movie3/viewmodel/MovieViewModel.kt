package io.github.latifah1105.movie3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.latifah1105.movie3.api.IService
import io.github.latifah1105.movie3.api.ResponseMovie
import io.github.latifah1105.movie3.api.Service
import io.github.latifah1105.movie3.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val client = Service.getClient().create(IService::class.java)

    private val listMovies = MutableLiveData<ArrayList<Result>>()

    fun setMovies(){
        client.getMovies().enqueue(object : Callback<ResponseMovie> {
            override fun onFailure(call: Call<ResponseMovie>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseMovie>, response: Response<ResponseMovie>) {
                response.body()?.let {
                    listMovies.postValue(it.results)
                }
            }

        })
    }
    internal fun getMovies(): LiveData<ArrayList<Result>> = listMovies
}