package com.example.dado

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener {
            rollDice()
        }
//Tira el dado al iniciar la app
        rollDice()

//desafio: Tirar 2 dados
        val roll2Button: Button = findViewById(R.id.rollButtonx2)
        roll2Button.setOnClickListener {
            rollDicex2()
        }
    }

    private fun rollDice() {

        val dice1 = Dice(6)
        val numRoll: Int = dice1.roll()
//        val resultTextView :TextView= findViewById(R.id.textView)
//        resultTextView.text = dice1.roll().toString()

        val dice2 = Dice(12)
//        val resultTextView2 : TextView = findViewById(R.id.textView2)
//        resultTextView2.text = dice2.roll().toString()

        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (numRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //actualizar imagen del dado
        diceImage.setImageResource(drawableResource)
        //actualizar contenido para ciegos (descripcion de contenido), debe ser String
        diceImage.contentDescription = numRoll.toString()


// Tambien se puede hacer así la seleccion de la imagen del dado segun el numero que salió
//        when(dice1.roll()){
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            6 -> diceImage.setImageResource(R.drawable.dice_6)
//        }

    }


    //desafio: Tirar 2 dados
    private fun rollDicex2() {

        val dice1 = Dice(6)
        val numRoll: Int = dice1.roll()
//        val resultTextView :TextView= findViewById(R.id.textView)
//        resultTextView.text = dice1.roll().toString()

        val dice2 = Dice(6)
        val numRoll2: Int = dice2.roll()
//        val resultTextView2 : TextView = findViewById(R.id.textView2)
//        resultTextView2.text = dice2.roll().toString()

        val diceImage: ImageView = findViewById(R.id.imageView2)
        val diceImage2: ImageView = findViewById(R.id.imageView3)

        val drawableResource = when (numRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (numRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //actualizar imagen del dado
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        //actualizar contenido para ciegos (descripcion de contenido), debe ser String
        diceImage.contentDescription = numRoll.toString()
        diceImage2.contentDescription = numRoll2.toString()
    }


    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}