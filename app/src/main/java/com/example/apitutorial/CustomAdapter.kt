package com.example.apitutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CustomAdapter(private val dataSet: List<Product>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val brandName: TextView
        val image: ImageView

        init {
            // Define click listener for the ViewHolder's View
            brandName = view.findViewById(R.id.brandName)
            image = view.findViewById(R.id.imageView)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.custom_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val currentItem = dataSet[position]
        viewHolder.brandName.text = currentItem.brand
        Picasso.get().load(currentItem.thumbnail).into(viewHolder.image)
    }

    override fun getItemCount() = dataSet.size

}