package com.learning.myshapesapplication

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var shapeDrawingView: ShapeDrawingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shapeDrawingView = findViewById(R.id.shape_drawing_view)
        val btnRectangle: Button = findViewById(R.id.btn_rectangle)
        val btnCircle: Button = findViewById(R.id.btn_circle)

        btnRectangle.setOnClickListener {
            shapeDrawingView.setShape(ShapeDrawingView.DrawingShape.RECTANGLE)
        }

        btnCircle.setOnClickListener {
            shapeDrawingView.setShape(ShapeDrawingView.DrawingShape.CIRCLE)
        }
    }
}

