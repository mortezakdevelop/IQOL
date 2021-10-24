package com.example.iqoldemo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.scale
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.iqoldemo.Adapter.ServiceTopItemsAdapter
import com.example.iqoldemo.databinding.ServiceBinding
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import dagger.internal.DaggerCollections
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.concurrent.thread
import kotlin.math.*
class HomeActivity : AppCompatActivity() {
    val viewModel:HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.i("TAG", "onCreate: ")
//        Log.i("TAG0010", "onCreate: ${viewModel.b.a.name}")
//        setContentView(R.layout.intro_slider_4)
//
//        setContentView(R.layout.test)
//        setContentView(R.layout.register_enter_pin)
//        setContentView(R.layout.home_layout)
        val binding = ServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.serviceRecyclerView.adapter = ServiceTopItemsAdapter(this)
    }
}


class A @Inject constructor()


@HiltViewModel
class HomeViewModel @Inject constructor(var a:A) : ViewModel()




