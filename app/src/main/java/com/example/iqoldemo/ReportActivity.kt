package com.example.iqoldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class ReportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

      val sp:Spinner= findViewById(R.id.spinner1)

        val items = arrayOf("Choose course", "NY", "NC", "ND")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        sp.adapter = adapter


    }
}