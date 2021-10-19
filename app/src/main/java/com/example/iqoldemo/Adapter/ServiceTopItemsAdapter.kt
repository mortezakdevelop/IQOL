package com.example.iqoldemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.iqoldemo.R
import com.example.iqoldemo.databinding.ServiceTopItemBinding

class ServiceTopItemsAdapter(var context: Context) :
    RecyclerView.Adapter<ServiceTopItemsAdapter.ServiceTopItemHolder>() {
    inner class ServiceTopItemHolder(var binding: ServiceTopItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class Item(
        var image: Int,
        var name: String
    )

    var list = listOf(
        Item(
            R.drawable.group_29,
            name = "All"
        ),
        Item(
            R.drawable.service,
            name = "Services"
        ),
        Item(
            R.drawable.packages,
            name = "Packages"
        ),
        Item(
            R.drawable.ribbon,
            name = "Cancer"
        ),
        Item(
            R.drawable.more_2,
            name = "More"
        ),

        )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceTopItemHolder {
        var binding =
            ServiceTopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceTopItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ServiceTopItemHolder, position: Int) {
        holder.binding.serviceTopItemImage.setImageDrawable(
            ContextCompat.getDrawable(
                context,
                list[position].image
            )
        )
        holder.binding.serviceTopItemName.text = list[position].name
    }

    override fun getItemCount() = list.size
}