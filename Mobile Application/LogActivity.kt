package com.example.pet

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class LogActivity : AppCompatActivity() {

    private lateinit var textViewDate: TextView
    private lateinit var logHelper: DatabaseHelper
    private lateinit var logNameEditText: EditText
    private lateinit var logDetailsEditText: EditText
    private lateinit var logCategorySpinner: Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logs_activity)

        // Initialize views
        textViewDate = findViewById(R.id.textViewDate)
        logNameEditText = findViewById(R.id.editTextLogName) // Initialize EditText for log name
        logDetailsEditText = findViewById(R.id.editTextLogDetails) // Initialize EditText for log details
        logCategorySpinner = findViewById(R.id.spinnerLogCategory)

        // Initialize DatabaseHelper
        logHelper = DatabaseHelper(this)

        // Set OnClickListener to show MaterialDatePicker
        textViewDate.setOnClickListener {
            showDatePicker()
            true
        }


        // Set OnClickListener for submit button
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        buttonSubmit.setOnClickListener {
            // Handle form submission
            val logName = logNameEditText.text.toString() // Retrieve log name from EditText
            val details = logDetailsEditText.text.toString() // Retrieve log details from EditText
            val logCategory = logCategorySpinner.selectedItem.toString()
            val currentDate = textViewDate.text.toString()

            val result = logHelper.addLog(logName, currentDate, details, logCategory)
            if (result != -1L) {
                showToast("Log added successfully")
                // Optionally, you can redirect to another activity after adding the log
                // startActivity(Intent(this, AnotherActivity::class.java))
                finish() // Finish the LogActivity after adding the log
            } else {
                showToast("Failed to add log")
            }
            finish() // Finish the LogActivity after adding the log
        }
    }

    private fun showDatePicker() {
        // Create MaterialDatePicker
        val builder = MaterialDatePicker.Builder.datePicker()
        val picker = builder.build()

        // Set listener for date selection
        picker.addOnPositiveButtonClickListener { selection ->
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selection
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val selectedDate = dateFormat.format(calendar.time)
            textViewDate.text = selectedDate
        }

        // Show the MaterialDatePicker
        picker.show(supportFragmentManager, picker.toString())
    }

    private fun showToast(message: String) {
        // Function to display a toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
