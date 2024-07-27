package com.example.sikl.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sikl.DetailActivity
import com.example.sikl.MainActivity
import com.example.sikl.R

class NewestAdapter(private val newest: ArrayList<Newest>,
                    private val context: Context?)
: RecyclerView.Adapter<NewestAdapter.NewestViewHolder>()  {
    class NewestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imgNew= itemView.findViewById<ImageView>(R.id.img_new)
        val titleNew = itemView.findViewById<TextView>(R.id.tv_name_new)
        val descNew = itemView.findViewById<TextView>(R.id.tv_desc_new)
        val newest = itemView.findViewById<CardView>(R.id.newest)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewestViewHolder {
        return NewestViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.newest, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewestViewHolder, position: Int) {
       val currentItem = newest[position]
        holder.imgNew.setImageResource(currentItem.imgNew)
        holder.titleNew.text = currentItem.titleNew
        holder.descNew.text = currentItem.descNew
        holder.newest.setOnClickListener {
            Toast.makeText(context,currentItem.titleNew,Toast.LENGTH_SHORT).show()
//            val  intent = Intent(context, DetailActivity::class.java).apply {
//                putExtra(DetailActivity.INTENT_PARCELABLE, currentItem)
//            }
//            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = newest.size

}