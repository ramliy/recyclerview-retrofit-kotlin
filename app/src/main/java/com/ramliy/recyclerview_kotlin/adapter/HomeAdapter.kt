package com.ramliy.recyclerview_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramliy.recyclerview_kotlin.R
import com.ramliy.recyclerview_kotlin.model.Result
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * Created by ramliy10 on 03/04/20.
 */
class HomeAdapter(val data: List<Result>) :
    RecyclerView.Adapter<HomeAdapter.TrainingHolder>() {

    class TrainingHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(get: Result) {
            itemView.tv_title.text = get.title
            itemView.tv_overview.text = get.overview

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TrainingHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
    )


    override fun getItemCount(): Int {
        return data.size ?: 0
    }

    override fun onBindViewHolder(holder: TrainingHolder, position: Int) {
        holder.bindView(data.get(position))
    }


}