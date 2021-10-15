package com.example.iqoldemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.iqoldemo.databinding.ActivityNameAppBinding

class NameAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameAppBinding
    private var currentLanguage: String = "English"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun clickLanguage() {
        binding.tvEnglish.setOnClickListener {
            //when click on english language
        }

        binding.tvPersian.setOnClickListener {
            //when click on persian language
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun clickedEnglishLanguage(){

    }

}

