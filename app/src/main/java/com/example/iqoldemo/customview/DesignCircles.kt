package com.example.iqoldemo.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.scale
import com.example.iqoldemo.R
import kotlin.concurrent.thread
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.tanh


class PulseView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var radiusPercent1 = 0f
    var radiusPercent2 = 0f
    var radiusPercent3 = 0f
    var bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.study).let {
        it.scale(200, 200)
    }
    var paint1 = Paint().apply {
        this.color = Color.argb(255, 0, 0, 125)
        this.isAntiAlias = true
    }
    var paint2 = Paint().apply {
        this.color = Color.argb(255, 0, 0, 125)
        this.isAntiAlias = true
    }
    var paint3 = Paint().apply {
        this.color = Color.argb(255, 0, 0, 125)
        this.isAntiAlias = true
    }

    init {
        thread {
            var count = 0f
            do {
                Thread.sleep(50)
                count += 0.03f
                var exp = exp(-count * count)
                radiusPercent1 = (1f - exp) * 0.8f + 0.2f
                paint1.color = Color.argb((255 * exp).toInt(), 0, 0, 255)
                if (radiusPercent1 >= 0.999f) {
                    radiusPercent1 = 0f
                    count = 0f
                }
                postInvalidate()
            } while (true)
        }
        thread {
            var count = 0f
            Thread.sleep(800)
            do {
                Thread.sleep(50)
                count += 0.03f
                var exp = exp(-count * count)
                radiusPercent2 = (1f - exp) * 0.8f + 0.2f
                paint2.color = Color.argb((255 * exp).toInt(), 0, 0, 255)
                if (radiusPercent2 >= 0.999f) {
                    radiusPercent2 = 0f
                    count = 0f
                }
                postInvalidate()
            } while (true)
        }
        thread {
            var count = 0f
            Thread.sleep(1600)
            do {
                Thread.sleep(50)
                count += 0.03f
                var exp = exp(-count * count)
                radiusPercent3 = (1f - exp) * 0.8f + 0.2f
                paint3.color = Color.argb((255 * exp).toInt(), 0, 0, 255)
                if (radiusPercent3 >= 0.999f) {
                    radiusPercent3 = 0f
                    count = 0f
                }
                postInvalidate()
            } while (true)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            var cx = width / 2f
            var cy = height / 2f
            var radius1 = cx * radiusPercent1
            var radius2 = cx * radiusPercent2
            var radius3 = cx * radiusPercent3
            it.drawCircle(cx, cy, radius1, paint1)
            it.drawCircle(cx, cy, radius2, paint2)
            it.drawCircle(cx, cy, radius3, paint3)
            it.drawCircle(cx, cy, 150f, Paint().apply {
                color = Color.BLACK
                isAntiAlias = true
            })
            it.drawBitmap(bitmap, cx - bitmap.width / 2f, cy - bitmap.height / 2f, null)
        }
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