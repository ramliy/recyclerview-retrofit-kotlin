package com.ramliy.recyclerview_kotlin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.ramliy.recyclerview_kotlin.adapter.HomeAdapter
import com.ramliy.recyclerview_kotlin.model.Result
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HomeContract.HomeView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*Init presenter
        * then cal func load movie
        * */
        val presenter = HomePresenter(this)
        presenter.onLoadMovie()

    }

    override fun onShowLoading() {
        pb_home.visibility = View.VISIBLE

    }

    override fun onHideLoading() {
        pb_home.visibility = View.GONE

    }

    override fun onShowResponse(result: List<Result>) {
        rv_home.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL
            )
        )
        rv_home.adapter = HomeAdapter(result)

    }

    override fun onFailure(errror: Throwable) {
        Toast.makeText(this@MainActivity, errror.message,Toast.LENGTH_SHORT).show()
    }

}
