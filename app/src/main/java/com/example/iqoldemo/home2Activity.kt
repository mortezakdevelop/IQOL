package com.example.iqoldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator

class home2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
        val   circularProgress:CircularProgressIndicator = findViewById(R.id.circular_progress1);
        val btn_security: Button =findViewById(R.id.change_security_code)
// you can set max and current progress values individually
        circularProgress.setMaxProgress(10000.0);
        circularProgress.setCurrentProgress(5000.0);
// or all at once
        circularProgress.setProgress(5000.0, 10000.0);

// you can get progress values using following getters
        circularProgress.getProgress() // returns 5000
        circularProgress.getMaxProgress() // returns 10000
        btn_security.setOnClickListener(View.OnClickListener {  })
    }
}