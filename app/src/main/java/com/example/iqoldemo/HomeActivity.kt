package com.example.iqoldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.iqoldemo.Adapter.ServiceTopItemsAdapter
import com.example.iqoldemo.databinding.ServiceBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=  ServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.serviceRecyclerView.adapter = ServiceTopItemsAdapter(this)
    }
}