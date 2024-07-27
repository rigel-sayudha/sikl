package com.example.sikl.ui.explore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sikl.R

class ExploreAdapter(private val explore: ArrayList<Explore>)
    : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    class ExploreViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imgExp = itemView.findViewById<ImageView>(R.id.img_explore)
        val titleExp = itemView.findViewById<TextView>(R.id.tv_name_explore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        return ExploreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.explore, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val currentItem = explore[position]
        holder.imgExp.setImageResource(currentItem.imgExp)
        holder.titleExp.text = currentItem.titleExp
    }

    override fun getItemCount(): Int = explore.size
}