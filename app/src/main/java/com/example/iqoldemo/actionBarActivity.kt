package com.example.iqoldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class actionBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar)

        val sp: Spinner = findViewById(R.id.spinner1)

        val items = arrayOf("Name Package")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        sp.adapter = adapter
    }
}