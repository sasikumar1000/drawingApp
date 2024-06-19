package com.learning.myshapesapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class ShapeDrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var startX = 0f
    private var startY = 0f
    private var endX = 0f
    private var endY = 0f
    private var drawingShape = DrawingShape.RECTANGLE // Default shape

    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    enum class DrawingShape {
        RECTANGLE, CIRCLE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        when (drawingShape) {
            DrawingShape.RECTANGLE -> {
                canvas.drawRect(RectF(startX, startY, endX, endY), paint)
            }
            DrawingShape.CIRCLE -> {
                val radius = Math.sqrt(Math.pow((endX - startX).toDouble(), 2.0) + Math.pow((endY - startY).toDouble(), 2.0)).toFloat()
                canvas.drawCircle(startX, startY, radius, paint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y
            }
            MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                endX = event.x
                endY = event.y
                invalidate()
            }
        }
        return true
    }

    fun setShape(shape: DrawingShape) {
        drawingShape = shape
    }
}
