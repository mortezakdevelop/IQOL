package com.example.iqoldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.iqoldemo.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()

        binding.registerButton.setOnClickListener{
         var  intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun bind(){
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



}