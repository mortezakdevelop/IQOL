package com.example.iqoldemo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.iqoldemo.Adapter.ServiceTopItemsAdapter
import com.example.iqoldemo.databinding.ServiceBinding
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.math.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_slider_4)
//        setContentView(R.layout.test)
//        setContentView(R.layout.register_enter_pin)
//        setContentView(R.layout.home_layout)
        val binding = ServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.serviceRecyclerView.adapter = ServiceTopItemsAdapter(this)
    }
}

class DesignCircles @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    var paint = Paint().apply {
        isAntiAlias = true
        color = Color.argb(120, 250, 250, 250)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let { canvas ->
            val x = width / 15f
            val y = height / 10f
            fun exp2(input: Float): Float {
                return tanh(input.toDouble()).toFloat()
            }

            for (i in 0..10) {
                if (
                    i !in listOf(0, 3, 6, 7)
                ) {
                    val x = (i / 10f) * width
                    val y = exp2(i / 10f) * height
                    val r = sin((i / 10f) * PI) * 25f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }
            for (i in 0..10) {
                if (
                    i !in listOf(4, 2, 1)
                ) {
                    val x = ((i / 10f) + 0.2f) * width
                    val y = (exp2(i / 10f) - 0.2f) * height
                    val r = sin((i / 10f) * PI) * 15f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }
            for (i in 0..10) {
                if (
                    i in listOf(0, 1, 2, 3)
                ) {
                    val x = ((i / 10f) - 0.1f) * width
                    val y = (exp2(i / 10f) + 0.1f) * height
                    val r = sin((i / 10f) * PI) * 11f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }
            for (i in 0..10) {
                if (
                    i !in listOf(7, 1, 5, 3)
                ) {
                    val x = ((i / 10f)) * width
                    val y = (exp2(i / 10f) + 0.2f) * height
                    val r = sin((i / 10f) * PI) * 11f
                    canvas.drawCircle(x, y, r.toFloat(), paint)
                }
            }

            canvas.drawCircle(x, y * 8, 11f, paint)
            canvas.drawCircle(x * 3, y * 8, 15f, paint)
            canvas.drawCircle(x * 4, y * 5, 30f, paint)
            canvas.drawCircle(x * 2, y * 6, 11f, paint)
            canvas.drawCircle(x * 4.2f, y * 5.5f, 15f, paint)
            canvas.drawCircle(x * 13, y * 8, 26f, paint)
            canvas.drawCircle(x * 10, y * 6, 16f, paint)
        }
    }
}

class WaveFrame @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    var path = Path()
    var count = 1f
    var moveX = 0f
    var paint = Paint().apply {
        isAntiAlias = true
        color = ResourcesCompat.getColor(context.resources, R.color.blue, null)
        strokeWidth = 5f
        style = Paint.Style.FILL
    }

    init {
        Executors.newSingleThreadExecutor().execute {
            var count = 0f
            do {
                Thread.sleep(30)
                count += 0.005f
                moveX += ((PI / 60f).toFloat())
                if (moveX % (PI / 2f) == 0.0) {
                    moveX = 0f
                }
                var sin = (sin(count * PI) * sin(count * PI)).toFloat()
                this.count = exp(-(sin) * (sin) * 0.09f)
                postInvalidate()
            } while (true)
        }
    }

    fun Path.addWave(width: Float, height: Float) {
        reset()
        var dx = width / 100f
        moveTo(0f, 0f)
        for (i in 0..100) {
            var x = dx * i
            var y =
                ((1 + sin(moveX + (x / width) * count * PI)) / 2f) * (height / 4f) + (0.75f * height)
            lineTo(x, y.toFloat())
        }
        lineTo(width, 0f)
        close()
    }

    init {
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        path.addWave(width.toFloat(), height.toFloat())
        canvas?.let {
            canvas.drawPath(path, paint)
        }
    }


}