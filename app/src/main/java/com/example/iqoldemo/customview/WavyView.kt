package com.example.iqoldemo.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.iqoldemo.R
import java.util.concurrent.Executors
import kotlin.math.PI
import kotlin.math.sin

class WavyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    var path = Path()
    var count = 1f
    var moveX = 0f
    var heightPercent = 10f
    var paint = Paint().apply {
        isAntiAlias = true
        color = ResourcesCompat.getColor(context.resources, R.color.blue, null)
        strokeWidth = 5f
        style = Paint.Style.FILL
    }

    init {
        Executors.newSingleThreadExecutor().execute {
            var total = 1000
            var step = 1f / total
            var intCount = 0
            var count = 0f
            do {
                Thread.sleep(10)
                intCount++
                count = step * intCount
                moveX = (4 * PI / (1 / step)).toFloat() * intCount
                if (intCount == total) {
                    intCount = 0
                    moveX = 0f
                    count = 0f
                }
                var sin = (sin(count * PI) * sin(count * PI)).toFloat()
                this.count = sin * 0.5f
                this.heightPercent = (1 - sin) * 0.3f + 0.7f
//                this.heightPercent = 0.6f
                postInvalidate()
            } while (true)
        }
    }

    fun Path.addWave(width: Float, height: Float) {
        reset()
        var dx = width / 100f
        moveTo(0f, 0f)
        var percent = heightPercent
        for (i in 0..100) {
            var x = dx * i
            var sin = sin(moveX + ((x / width) * count * PI))
            var y =
                (sin * sin) * (height * (1 - percent)) + (percent) * height
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