package com.example.iqoldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.iqoldemo.Adapter.ViewPagerAdapter
import com.example.iqoldemo.databinding.ActivityMainBinding
import me.relex.circleindicator.CircleIndicator
import me.relex.circleindicator.CircleIndicator3


class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    private var textTitle = mutableListOf<String>()
    private var _image = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        postToList()

        //initial adapter and indicator
        binding.viewPager2.adapter = ViewPagerAdapter(textTitle,_image)
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(binding.viewPager2)
    }
    private fun bind(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun addToList(title:String,image:Int){
        textTitle.add(title)
        _image.add(image)
    }

    private fun postToList(){
        for (i in 1..4){
            addToList("${i}",R.mipmap.ic_launcher)
        }
    }
}