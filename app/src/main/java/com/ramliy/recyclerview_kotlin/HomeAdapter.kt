package com.ramliy.recyclerview_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ramliy.recyclerview_kotlin.model.HomeResponse
import com.ramliy.recyclerview_kotlin.model.Result

/**
 * Created by ramliy10 on 02/04/20.
 */

class HomeAdapter(private val result: List<Result>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(result[position])
    }

    override fun getItemCount(): Int = result.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.findViewById<TextView>(R.id.tv_title)
        private val overview = view.findViewById<TextView>(R.id.tv_title)

        fun bindItem(result:Result) {
            title.text = result.title
            overview.text = result.overview

        }
    }
}

