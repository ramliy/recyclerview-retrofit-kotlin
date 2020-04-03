package com.ramliy.recyclerview_kotlin

import com.ramliy.recyclerview_kotlin.model.Result

/**
 * Created by ramliy10 on 03/04/20.
 */
class HomeContract {
    interface HomeView{
        fun onShowLoading();
        fun onHideLoading();
        fun onShowResponse(result : List<Result>)
        fun onFailure(errror: Throwable)



    }

    interface HomePresenter{
        fun onLoadMovie()
    }
}