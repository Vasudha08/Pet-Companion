package com.example.pet


import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import android.webkit.WebView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView

import androidx.appcompat.app.AppCompatActivity


class TrainingGuidesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training_activity)

        // Initialize ImageViews
        val imageViewLieDown = findViewById<ImageView>(R.id.imageViewLieDown)
        val imageViewHandshake = findViewById<ImageView>(R.id.imageViewHandshake)
        val imageViewSit = findViewById<ImageView>(R.id.imageViewSit)

        // Initialize ListView adapters
        val stepsLieDown = resources.getStringArray(R.array.steps_lie_down)
        val adapterLieDown = ArrayAdapter(this, android.R.layout.simple_list_item_1, stepsLieDown)
        val stepsHandshake = resources.getStringArray(R.array.steps_handshake)
        val adapterHandshake = ArrayAdapter(this, android.R.layout.simple_list_item_1, stepsHandshake)
        val stepsSit = resources.getStringArray(R.array.steps_sit)
        val adapterSit = ArrayAdapter(this, android.R.layout.simple_list_item_1, stepsSit)

        // Set adapters to ListViews
        findViewById<ListView>(R.id.listViewLieDown).adapter = adapterLieDown
        findViewById<ListView>(R.id.listViewHandshake).adapter = adapterHandshake
        findViewById<ListView>(R.id.listViewSit).adapter = adapterSit

        // Set onFocusChangeListener to ImageViewLieDown
        imageViewLieDown.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                // Enlarge and show the image
                imageViewLieDown.scaleX = 1.5f // Increase X scale by 1.5
                imageViewLieDown.scaleY = 1.5f // Increase Y scale by 1.5
                imageViewLieDown.visibility = View.VISIBLE // Show the ImageView
            } else {
                // Shrink and hide the image
                imageViewLieDown.scaleX = 1.0f // Restore original X scale
                imageViewLieDown.scaleY = 1.0f // Restore original Y scale
                imageViewLieDown.visibility = View.GONE // Hide the ImageView
            }
        }

        // Similarly, set onFocusChangeListener for other ImageViews
        imageViewHandshake.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                // Enlarge and show the image
                imageViewLieDown.scaleX = 1.5f // Increase X scale by 1.5
                imageViewLieDown.scaleY = 1.5f // Increase Y scale by 1.5
                imageViewLieDown.visibility = View.VISIBLE // Show the ImageView
            } else {
                // Shrink and hide the image
                imageViewLieDown.scaleX = 1.0f // Restore original X scale
                imageViewLieDown.scaleY = 1.0f // Restore original Y scale
                imageViewLieDown.visibility = View.GONE // Hide the ImageView
            }
        }

        imageViewSit.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                // Enlarge and show the image
                imageViewLieDown.scaleX = 1.5f // Increase X scale by 1.5
                imageViewLieDown.scaleY = 1.5f // Increase Y scale by 1.5
                imageViewLieDown.visibility = View.VISIBLE // Show the ImageView
            } else {
                // Shrink and hide the image
                imageViewLieDown.scaleX = 1.0f // Restore original X scale
                imageViewLieDown.scaleY = 1.0f // Restore original Y scale
                imageViewLieDown.visibility = View.GONE // Hide the ImageView
            }
        }
    }
}
