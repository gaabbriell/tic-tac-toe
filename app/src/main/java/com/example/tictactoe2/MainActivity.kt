package com.example.tictactoe2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.StartGameButton)

        button.setOnClickListener {
            callActivity()
        }

    }
    private fun callActivity() {
        val P1Name = findViewById<EditText>(R.id.P1Name)
        val P2Name = findViewById<EditText>(R.id.P2Name)

        val message1 = P1Name.text.toString()
        val message2 = P2Name.text.toString()

        val intent = Intent(this, MainActivity2::class.java).also {
            it.putExtra("EXTRA_MESSAGE1", message1)
            it.putExtra("EXTRA_MESSAGE2", message2)
            startActivity(it)

        }
    }
}