package com.ramliy.recyclerview_kotlin

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.ramliy.recyclerview_kotlin.model.HomeResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by ramliy10 on 03/04/20.
 */
class HomePresenter(private val view: HomeContract.HomeView) : HomeContract.HomePresenter {


    override fun onLoadMovie() {
        view.onShowLoading()
        NetworkProvider().api().discoverMovie()
            .enqueue(object : Callback<HomeResponse> {
                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                    view.onHideLoading()
                    view.onFailure(t)
                }

                override fun onResponse(
                    call: Call<HomeResponse>,
                    response: Response<HomeResponse>
                ) {
                    view.onHideLoading()
                    view.onShowResponse(response.body()?.results?: emptyList())


                }

            })
    }


}