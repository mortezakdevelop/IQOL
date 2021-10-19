package com.example.iqoldemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.iqoldemo.Adapter.ServiceTopItemsAdapter
import com.example.iqoldemo.databinding.ServiceBinding
import java.util.*
import kotlin.math.PI
import kotlin.math.sin
import kotlin.math.tanh

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.home_layout)
        val binding = ServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.serviceRecyclerView.adapter = ServiceTopItemsAdapter(this)
    }
}

class DesignCircles @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint().apply {
        isAntiAlias = true
        color = Color.argb(120, 250, 250, 250)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let { canvas ->
            var x = width / 15f
            var y = height / 10f
            fun exp2(input: Float): Float {
                return tanh(input.toDouble()).toFloat()
            }

            for (i in 0..10) {
                if (
                    i !in listOf(0, 3, 6, 7)
                ) {
                    var x = (i / 10f) * width
                    var y = exp2(i / 10f) * height
                    var r = sin((i / 10f) * PI) * 25f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }
            for (i in 0..10) {
                if (
                    i !in listOf(4, 2, 1)
                ) {
                    var x = ((i / 10f) + 0.2f) * width
                    var y = (exp2(i / 10f) - 0.2f) * height
                    var r = sin((i / 10f) * PI) * 15f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }
            for (i in 0..10) {
                if (
                    i in listOf(0, 1, 2,3)
                ) {
                    var x = ((i / 10f) - 0.1f) * width
                    var y = (exp2(i / 10f) + 0.1f) * height
                    var r = sin((i / 10f) * PI) * 11f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }
            for (i in 0..10) {
                if (
                    i !in listOf(7, 1, 5,3)
                ) {
                    var x = ((i / 10f)) * width
                    var y = (exp2(i / 10f) + 0.2f) * height
                    var r = sin((i / 10f) * PI) * 11f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }

            canvas.drawCircle(x,y*8,11f,paint)
            canvas.drawCircle(x*3,y*8,15f,paint)
            canvas.drawCircle(x*4,y*5,30f,paint)
            canvas.drawCircle(x*2,y*6,11f,paint)
            canvas.drawCircle(x*4.2f,y*5.5f,15f,paint)
            canvas.drawCircle(x*13,y*8,26f,paint)
            canvas.drawCircle(x*10,y*6,16f,paint)



//            for (i in 0 until 10) {
//                for (j in 0 until 5) {
//                    canvas.drawCircle(
//                        x * i,
//                        y * j,
//                        Random(Calendar.getInstance().timeInMillis).nextInt(20).toFloat(),
//                        Paint().apply {
//                            color = Color.argb(120, 250, 250, 250)
//                            isAntiAlias = true
//                        })
//                }
//            }
//            x = width/20f
//            y = height/10f
//            for (i in 0 until 20) {
//                for (j in 0 until 10) {
//                    canvas.drawCircle(
//                        x * i,
//                        y * j,
//                        Random(Calendar.getInstance().timeInMillis).nextInt(5).toFloat(),
//                        Paint().apply {
//                            color = Color.argb(30, 250, 250, 250)
//                            isAntiAlias = true
//                        })
//                }
//            }
        }
    }
}