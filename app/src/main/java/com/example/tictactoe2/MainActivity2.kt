package com.example.tictactoe2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var Score: TextView


    private var firstPlayerScore = 0
    private var secondPlayerScore = 0

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val message1 = intent.getStringExtra("EXTRA_MESSAGE1")
        val message2 = intent.getStringExtra("EXTRA_MESSAGE2")

        val FirstName = findViewById<TextView>(R.id.FirstName).apply {
            text = message1
        }
        val SecondName = findViewById<TextView>(R.id.SecondName).apply {
            text = message2
        }


        init()
        reset()

    }
    private fun init() {
        button1 = findViewById(R.id.Button1)
        button2 = findViewById(R.id.Button2)
        button3 = findViewById(R.id.Button3)
        button4 = findViewById(R.id.Button4)
        button5 = findViewById(R.id.Button5)
        button6 = findViewById(R.id.Button6)
        button7 = findViewById(R.id.Button7)
        button8 = findViewById(R.id.Button8)
        button9 = findViewById(R.id.Button9)
        resetButton = findViewById(R.id.ResetButton)
        Score = findViewById(R.id.Score)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        resetButton.setOnClickListener{
            reset()
        }

    }


    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id) {
                R.id.Button1 -> buttonNumber = 1
                R.id.Button2 -> buttonNumber = 2
                R.id.Button3 -> buttonNumber = 3
                R.id.Button4 -> buttonNumber = 4
                R.id.Button5 -> buttonNumber = 5
                R.id.Button6 -> buttonNumber = 6
                R.id.Button7 -> buttonNumber = 7
                R.id.Button8 -> buttonNumber = 8
                R.id.Button9 -> buttonNumber = 9
            }
            if (buttonNumber !=0) {
                playGame(buttonNumber, clickedView)
            }
        }
    }

    private fun playGame(buttonNumber: Int, clickedView: Button) {
        if (activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.GRAY)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        }   else if (activePlayer == 2) {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.MAGENTA)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        clickedView.isEnabled = false
        check()
    }


    private fun disableButtons(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false

    }



    private fun check() {

        var winnerPlayer = 0
        Score.text = "$firstPlayerScore : $secondPlayerScore"

        var len1 = firstPlayer.size
        var len2 = secondPlayer.size

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winnerPlayer = 1
        }

        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winnerPlayer = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winnerPlayer = 2
        }


        if (winnerPlayer == 1) {
            Toast.makeText(this, "1ST PLAYER WON", Toast.LENGTH_SHORT).show()
            firstPlayerScore += 1
            disableButtons()

        }
        if (winnerPlayer == 2) {
            Toast.makeText(this, "2ND PLAYER WON", Toast.LENGTH_SHORT).show()
            secondPlayerScore += 1
            disableButtons()

        }else if (len1 + len2 == 9 && winnerPlayer != 1 && winnerPlayer !=2 ) {
            Toast.makeText(applicationContext, "DRAW!", Toast.LENGTH_SHORT).show()
        }


    }

    private fun reset() {
        var winnerPlayer = 0

        button1.text = ""
        button1.isEnabled = true
        button1.setBackgroundColor(Color.WHITE)
        button2.text = ""
        button2.isEnabled = true
        button2.setBackgroundColor(Color.WHITE)
        button3.text = ""
        button3.isEnabled = true
        button3.setBackgroundColor(Color.WHITE)
        button4.text = ""
        button4.isEnabled = true
        button4.setBackgroundColor(Color.WHITE)
        button5.text = ""
        button5.isEnabled = true
        button5.setBackgroundColor(Color.WHITE)
        button6.text = ""
        button6.isEnabled = true
        button6.setBackgroundColor(Color.WHITE)
        button7.text = ""
        button7.isEnabled = true
        button7.setBackgroundColor(Color.WHITE)
        button8.text = ""
        button8.isEnabled = true
        button8.setBackgroundColor(Color.WHITE)
        button9.text = ""
        button9.isEnabled = true
        button9.setBackgroundColor(Color.WHITE)

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2

        }
        firstPlayer.clear()
        secondPlayer.clear()

    }


}