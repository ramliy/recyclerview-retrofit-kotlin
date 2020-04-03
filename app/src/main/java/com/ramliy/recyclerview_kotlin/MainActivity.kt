package com.ramliy.recyclerview_kotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.ramliy.recyclerview_kotlin.adapter.HomeAdapter
import com.ramliy.recyclerview_kotlin.model.HomeResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pb_home.visibility = View.VISIBLE
        NetworkProvider().api().discoverMovie()
            .enqueue(object : Callback<HomeResponse> {
                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message,Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<HomeResponse>,
                    response: Response<HomeResponse>
                ) {
                    val results = response.body()?.results
                    pb_home.visibility = View.GONE
                    rv_home.adapter = HomeAdapter(results ?: emptyList())
                    rv_home.addItemDecoration(
                        DividerItemDecoration(
                            this@MainActivity,
                            DividerItemDecoration.VERTICAL
                        )
                    )
                }

            })

    }

}
