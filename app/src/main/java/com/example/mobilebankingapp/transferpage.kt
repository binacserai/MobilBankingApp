package com.example.mobilebankingapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class transferpage:AppCompatActivity() {
    private lateinit var radioButton1: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var radioButton3: RadioButton
    private lateinit var radioButton4: RadioButton
    private lateinit var radioButton5: RadioButton
    private lateinit var selectedOptionTextView: TextView
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferpage)

        supportActionBar?.hide()
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        radioButton4 = findViewById(R.id.radioButton4)
        radioButton5 = findViewById(R.id.radioButton5)
        selectedOptionTextView = findViewById(R.id.RECEIVEREDIT)

        val receivedAmount = intent.getStringExtra("amount")

        // Use the receivedAmount as needed in your activity
        // For example, you can set it in a TextView
        val SENDEREDIT = findViewById<TextView>(R.id.SENDEREDIT)
        SENDEREDIT.text = receivedAmount

        databaseHelper = DatabaseHelper(this)

        val doneButton = findViewById<Button>(R.id.DONE)
        doneButton.setOnClickListener {
            val sender = SENDEREDIT.text.toString()
            val receiver = findViewById<EditText>(R.id.RECEIVEREDIT).text.toString()
            val amount = findViewById<EditText>(R.id.AMOUNTEDIT).text.toString()

            databaseHelper.saveTransfer(sender, receiver, amount)

            // Perform any additional actions or show a confirmation message

            finish() // Close the activity after saving the data
        }

        radioButton1.setOnClickListener {
            val selectedOption = radioButton1.text.toString()
            selectedOptionTextView.text = " $selectedOption"
        }
        radioButton2.setOnClickListener {
            val selectedOption = radioButton2.text.toString()
            selectedOptionTextView.text = "$selectedOption"
        }
        radioButton3.setOnClickListener {
            val selectedOption = radioButton3.text.toString()
            selectedOptionTextView.text = "$selectedOption"
        }
        radioButton4.setOnClickListener {
            val selectedOption = radioButton4.text.toString()
            selectedOptionTextView.text = "$selectedOption"
        }
        radioButton5.setOnClickListener {
            val selectedOption = radioButton5.text.toString()
            selectedOptionTextView.text = "$selectedOption"
        }
    }
}




