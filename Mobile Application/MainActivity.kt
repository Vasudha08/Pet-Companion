package com.example.pet

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pet.DatabaseHelper
import com.example.pet.DashboardActivity

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        databaseHelper = DatabaseHelper(this)

        // Set onFocusChangeListener for username EditText
        usernameEditText.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                // Validate username when focus is lost
                validateUsername(usernameEditText.text.toString())
            }
        }

        // Set OnKeyListener for password EditText
        passwordEditText.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                // Perform login when enter key is pressed
                performLogin()
                return@setOnKeyListener true
            }
            false
        }

        // Set click listener for login button
        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            performLogin()
        }
    }

    private fun validateUsername(username: String) {
        // Perform username validation here
        if (username.isEmpty()) {
            usernameEditText.error = "Username cannot be empty"
        } else {
            usernameEditText.error = null
        }
    }

    private fun performLogin() {
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        databaseHelper.addUser("21z267", "vasudha")
        // Check if username and password exist in the database
        if (isValidUser(username, password)) {
            // Login successful, navigate to the DashboardActivity
            showToast("Login Successful")
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish() // Finish MainActivity to prevent going back to it by pressing back button
        } else {
            showToast("Invalid username or password")
        }
    }

    private fun isValidUser(username: String, password: String): Boolean {
        return databaseHelper.getUser(username, password)

    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
