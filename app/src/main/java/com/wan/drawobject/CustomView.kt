package com.wan.drawobject

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Region
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context) {

    private val bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)
    private val paint = Paint()
    private val paintText = Paint(Paint.FAKE_BOLD_TEXT_FLAG)
    private val bounds = Rect()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(bitmap.width, bitmap.height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawColor(ResourcesCompat.getColor(resources, R.color.light_blue_600, null))

        canvas.save() // menyimpan pengaturan sebelumnya.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            canvas.clipRect(
                bitmap.width / 2 - 100F,
                bitmap.height / 2 - 100F,
                bitmap.width / 2 + 100F,
                bitmap.height / 2 + 100F,
                Region.Op.DIFFERENCE
            )
        } else {
            canvas.clipOutRect(
                bitmap.width / 2 - 100,
                bitmap.height / 2 - 100,
                bitmap.width / 2 + 100,
                bitmap.height / 2 + 100
            )
        }

        paint.color = ResourcesCompat.getColor(resources, R.color.light_blue_400, null)
        canvas.drawCircle((bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat(), 200f, paint)
        canvas.restore() // mengembalikan pengaturan yang telah tersimpan.

        paintText.textSize = 20F
        paintText.color = ResourcesCompat.getColor(resources, R.color.white, null)

        val text = "Selamat Datang!"
        paintText.getTextBounds(text, 0, text.length, bounds)

        val x: Int = bitmap.width / 2 - bounds.centerX()
        val y: Int = bitmap.height / 2 - bounds.centerY()
        canvas.drawText(text, x.toFloat(), y.toFloat(), paintText)
    }
}
