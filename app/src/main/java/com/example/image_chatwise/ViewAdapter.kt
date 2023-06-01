package com.example.image_chatwise


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.image_chatwise.models.image


class photoListAdapter():RecyclerView.Adapter<photoviewholder>() {
    private var items:image= image()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): photoviewholder {
          val view =LayoutInflater.from(parent.context).inflate(R.layout.item_photo,parent,false)
          val viewholder=photoviewholder(view)
          return viewholder
    }

    override fun onBindViewHolder(holder: photoviewholder, position: Int) {
        Glide.with(holder.itemView.context).load(items[position].url).into(holder.image)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    fun update(updatedphotos: image){
        items=updatedphotos
        notifyDataSetChanged()
    }
}
class photoviewholder(itemview:View):RecyclerView.ViewHolder(itemview){
    val image=itemview.findViewById<ImageView>(R.id.image)
}

