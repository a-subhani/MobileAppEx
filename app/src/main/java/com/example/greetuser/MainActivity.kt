package com.example.greetuser


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        textViewResult = findViewById(R.id.textViewResult)
    }

    fun onGreetButtonClick(view: View) {
        val name = editTextName.text.toString().trim()

        if (name.isNotEmpty()) {
            val greeting = getGreetingMessage()
            val personalizedGreeting = "$greeting, $name!"
            textViewResult.text = personalizedGreeting
        } else {
            textViewResult.text = "Please enter your name."
        }
    }

    private fun getGreetingMessage(): String {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        return when {
            hourOfDay in 6..11 -> "Good morning"
            hourOfDay in 12..16 -> "Good afternoon"
            hourOfDay in 17..20 -> "Good evening"
            else -> "Good night"
        }
    }
}
