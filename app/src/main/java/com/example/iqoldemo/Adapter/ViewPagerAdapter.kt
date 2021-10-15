package com.example.iqoldemo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.iqoldemo.R

class ViewPagerAdapter(private var textTitle: List<String>, private var image: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textTitle: TextView = itemView.findViewById(R.id.tv_textView)
        val image: ImageView = itemView.findViewById(R.id.iv_imageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
       holder.textTitle.text = textTitle[position]
        holder.image.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return textTitle.size
    }
}