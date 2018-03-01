package com.hencoder.hencoderpracticedraw2.practice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

import com.hencoder.hencoderpracticedraw2.R

class Practice06LightingColorFilterView : View {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var bitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        paint.colorFilter = LightingColorFilter(0x00ffff, 0x000000)
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap, 0f, 0f, paint)

        paint.colorFilter = LightingColorFilter(0xffffff, 0x005500)
        // 第二个 LightingColorFilter：增强绿色部分
        canvas.drawBitmap(bitmap, (bitmap.width + 100).toFloat(), 0f, paint)
    }
}
