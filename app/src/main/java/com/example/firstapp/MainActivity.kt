package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val Texto1 = findViewById<EditText>(R.id.editText)
        val Texto2 = findViewById<EditText>(R.id.editText2)
        val RadioButton = findViewById<RadioButton>(R.id.radioButtonSum)
        val RadioButton2 = findViewById<RadioButton>(R.id.radioButtonSubstract)

        fun toInteger(Texto1: String){
            val value = Texto1.toInt()
        }

        RadioButton.setOnClickListener {
            var suma = 0
            if (RadioButton.isChecked){

            }
    }
}
}

fun main() {
}