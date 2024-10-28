package com.wan.drawobject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wan.drawobject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        val bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888)
//        binding.myImageView.setImageBitmap(bitmap)
//        val canvas = Canvas(bitmap)
//        val paint = Paint()
//        canvas.save()
//
//        paint.color = ResourcesCompat.getColor(resources, R.color.gray_600, null)
//        val rect = Rect()
//        rect.set(
//            bitmap.width / 2 - 100,
//            bitmap.height / 2 - 100,
//            bitmap.width / 2 + 100,
//            bitmap.height / 2 + 100,
//        )
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            canvas.clipOutRect(rect)
//        } else {
//            canvas.clipRect(rect, Region.Op.DIFFERENCE)
//        }
//
//        paint.color = ResourcesCompat.getColor(resources, R.color.light_blue_600, null)
//        canvas.drawColor(ResourcesCompat.getColor(resources, R.color.light_blue_400, null))
//        canvas.drawCircle(
//            (bitmap.width / 2).toFloat(),
//            (bitmap.height / 2).toFloat(),
//            200f,
//            paint
//        )
//
//        val paintText = Paint(Paint.FAKE_BOLD_TEXT_FLAG)
//        paintText.textSize = 20F
//        paintText.color = ResourcesCompat.getColor(resources, R.color.white, null)
//        val text = "Selamat Datang!"
//        val bounds = Rect()
//        paintText.getTextBounds(text, 0, text.length, bounds)
//        val x: Int = bitmap.width / 2 - bounds.centerX()
//        val y: Int = bitmap.height / 2 - bounds.centerY()
//        canvas.drawText(text, x.toFloat(), y.toFloat(), paintText)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}