package com.example.firstapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val Texto1 = findViewById<EditText>(R.id.editText)
        val Texto2 = findViewById<EditText>(R.id.editText2)
        val RadioButton = findViewById<RadioButton>(R.id.radioButtonSum)
        val RadioButton2 = findViewById<RadioButton>(R.id.radioButtonSubstract)

        RadioButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val num1 = Texto1.text.toString().toInt()
                val num2 = Texto2.text.toString().toInt()

                val suma = num1 + num2

                val resultado = findViewById<TextView>(R.id.editText3)
                resultado.text = "Resultado: $suma"
            }
        }

        RadioButton2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                val num1 = Texto1.text.toString().toInt()
                val num2 = Texto2.text.toString().toInt()

                val resta = num1 - num2

                val resultado = findViewById<TextView>(R.id.editText3)
                resultado.text = "Resultado: $resta"
            }
        }
    }
}