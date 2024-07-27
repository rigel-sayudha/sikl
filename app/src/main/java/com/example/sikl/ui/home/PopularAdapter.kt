package com.example.sikl.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sikl.DetailActivity
import com.example.sikl.DetailActivity.Companion.INTENT_PARCELABLE
import com.example.sikl.R
import com.google.android.material.button.MaterialButton

class PopularAdapter(
    private val popular: ArrayList<Popular>,
    private val context: Context?
)
    : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    class PopularViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        val imgPopular = itemView.findViewById<ImageView>(R.id.img_item_photo)
        val titlePopular = itemView.findViewById<TextView>(R.id.tv_item_name)
        val descPopular = itemView.findViewById<TextView>(R.id.tv_item_desc)
        val btnPopular = itemView.findViewById<MaterialButton>(R.id.btn_pop)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.popular, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val currentItem = popular[position]
        holder.imgPopular.setImageResource(currentItem.imgPopular)
        holder.titlePopular.text = currentItem.titlePopular
        holder.descPopular.text = currentItem.descPopular
        holder.btnPopular.setOnClickListener {
//            Toast.makeText(context,currentItem.titlePopular,Toast.LENGTH_SHORT).show()
            val  intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(INTENT_PARCELABLE,currentItem)
//                putExtra("IMG",currentItem.imgPopular)
//                putExtra("TITLE",currentItem.titlePopular)
//                putExtra("DESC",currentItem.descPopular)
            }
            context?.startActivity(intent)

            }
        }

    override fun getItemCount(): Int = popular.size


    }


