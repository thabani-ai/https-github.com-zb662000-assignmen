package  vcmsa.ci.myapplication1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val editTextTimeOfDay = findViewById<EditText>(R.id.editTextTimeOfDay)
        val buttonGetSuggestion = findViewById<Button>(R.id.buttonGetSuggestion)
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)
        val buttonReset = findViewById<Button>(R.id.buttonReset)

        // Button click listener for getting meal suggestion
        buttonGetSuggestion.setOnClickListener {
            // Get user input and convert to lowercase for easier comparison
            val timeOfDay = editTextTimeOfDay.text.toString().trim().lowercase()

            // Use a when statement to check the time of day and suggest a meal
            val suggestion = when (timeOfDay) {
                "morning" -> "Breakfast: Eggs & Toast 🍳"
                "mid-morning" -> "Snack: Fresh Fruit 🍎"
                "afternoon" -> "Lunch: Chicken Sandwich 🥪"
                "mid-afternoon" -> "Snack: Chocolate Cake 🍰"
                "dinner" -> "Dinner: Pasta 🍝"
                "after dinner" -> "Dessert: Ice Cream 🍦"
                else -> "Invalid input. Please enter a valid time of day."
            }

            // Display the meal suggestion in the TextView
            textViewSuggestion.text = suggestion
        }

        // Button click listener for resetting the input and output
        // code assistance provided bt Chatgpt
        // Source: OpenAI's ChatGPT
        buttonReset.setOnClickListener {
            editTextTimeOfDay.text.clear() // Clear the input field
            textViewSuggestion.text = "Meal suggestion will appear here" // Reset text
            Toast.makeText(this, "Reset Successful", Toast.LENGTH_SHORT).show() // Show a toast message
        }
    }
}
