package com.example.mystickerapp

import android.graphics.Color
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChangeColor.setOnClickListener {
            drawView.setColor(Color.BLUE)
        }

        btnNew.setOnClickListener {
            drawView.newDraw()
        }

        btnSave.setOnClickListener {
        drawView.isDrawingCacheEnabled = true
            MediaStore.Images.Media.insertImage(
                contentResolver,
                drawView.drawingCache,
                UUID.randomUUID().toString() + ".png",
                "drawing"
            )
            drawView.destroyDrawingCache()
        }

        btnSaveCut.setOnClickListener {

        }
    }
}
