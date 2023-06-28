package com.example.mobilebankingapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HOME : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.hide()

        val transfer1 = findViewById<Button>(R.id.transfer1)
        val transfer2 = findViewById<Button>(R.id.transfer2)
        val transfer3 = findViewById<Button>(R.id.transfer3)
        val transfer4 = findViewById<Button>(R.id.transfer4)
        val transfer5 = findViewById<Button>(R.id.transfer5)

        val history=findViewById<Button>(R.id.chech_history)

        transfer1.setOnClickListener {
            val name1 = findViewById<TextView>(R.id.name1)
            val datatransfer1 = name1.text.toString()
            val intent = Intent(this, transferpage::class.java)
            intent.putExtra("amount", datatransfer1)
            startActivity(intent)}


        transfer2.setOnClickListener {
            val name2=findViewById<TextView>(R.id.name2)
            val datatransfer2=name2.text.toString()
            val intent2 = Intent(this, transferpage::class.java)
            intent2.putExtra("amount",datatransfer2)
            startActivity(intent2)
        }

        transfer3.setOnClickListener {
            val name3 = findViewById<TextView>(R.id.name1)
            val datatransfer3=name3.text.toString()
            val intent3 = Intent(this, transferpage::class.java)
            intent3.putExtra("amount",datatransfer3)
            startActivity(intent3)
        }

        transfer4.setOnClickListener {
            val name4=findViewById<TextView>(R.id.name4)
            val datatransfer4=name4.text.toString()
            val intent4 = Intent(this, transferpage::class.java)
            intent4.putExtra("amount",datatransfer4)
            startActivity(intent4)
        }

        transfer5.setOnClickListener {
            val name5=findViewById<TextView>(R.id.name5)
            val datatransfer5=name5.text.toString()
            val intent5 = Intent(this, transferpage::class.java)
            intent5.putExtra("amount",datatransfer5)
            startActivity(intent5)
        }


        history.setOnClickListener{
            val intent7 = Intent(this, ryclehis::class.java)
            startActivity(intent7)
        }
    }
}




