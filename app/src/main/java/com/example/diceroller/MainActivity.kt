package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById<Button>(R.id.button)
        rollButton.setOnClickListener {
            /*val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show();
            val resultTextView: TextView = findViewById(R.id.textView)
            resultTextView.text = "6"
             */
            rolldice()
        }

    }

    private fun rolldice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = diceRoll.toString()

        val diceImage: ImageView = findViewById(R.id.imageView)

        /*
        when(diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }
        */
        val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)

        val drawableResource = when(diceRoll) {
            1 -> {
                R.drawable.dice_1
            }
            2 -> {
                R.drawable.dice_2
            }
            3 -> {
                R.drawable.dice_3
            }
            4 -> {
                R.drawable.dice_4
            }
            5 -> {
                R.drawable.dice_5
            }
            else -> {
                R.drawable.dice_6
            }
        }

        diceImage.setImageResource(drawableResource)
        toast.show();
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}