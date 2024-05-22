package com.example.pet


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity




import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)

        // Set click listener for the Training Guides button
        val btnTrainingGuides = findViewById<Button>(R.id.btnTrainingGuides)
        val btnLogs = findViewById<Button>(R.id.btnLogs)
        val btnPawCareDirectory = findViewById<Button>(R.id.btnPawCareDirectory)

        // Set click listener for the Training Guides button
        btnTrainingGuides.setOnClickListener {
            // Start TrainingGuidesActivity when Training Guides button is clicked
            val intent = Intent(this, TrainingGuidesActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for the Logs button
        btnLogs.setOnClickListener {
            // Start LogActivity when Logs button is clicked
            val intent = Intent(this, LogActivity::class.java)
            startActivity(intent)
        }

        btnPawCareDirectory.setOnClickListener {
            // Start LogActivity when Logs button is clicked
            val intent = Intent(this, ResourceActivity::class.java)
            startActivity(intent)
        }
    }
}
