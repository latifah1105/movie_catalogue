package io.github.latifah1105.movie3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.latifah1105.movie3.api.IService
import io.github.latifah1105.movie3.api.ResponseTvShow
import io.github.latifah1105.movie3.api.Service
import io.github.latifah1105.movie3.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvViewModel : ViewModel() {

    private val client = Service.getClient().create(IService::class.java)

    private val listTv = MutableLiveData<ArrayList<Result>>()

    fun setTvShow() {
        client.getTv().enqueue(object : Callback<ResponseTvShow> {
            override fun onFailure(call: Call<ResponseTvShow>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseTvShow>, response: Response<ResponseTvShow>) {
                response.body()?.let {
                    listTv.postValue(it.results)
                }
            }
        })
    }
    internal fun getTvShow(): LiveData<ArrayList<Result>> = listTv
}
