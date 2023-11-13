package com.example.firstapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Texto1 = findViewById<EditText>(R.id.editText)
        val Texto2 = findViewById<EditText>(R.id.editText2)
        val RadioButton = findViewById<RadioButton>(R.id.radioButtonSum)
        val RadioButton2 = findViewById<RadioButton>(R.id.radioButtonSubstract)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButtonSum -> {
                    try{
                        val num1 = Texto1.text.toString().toInt()
                        val num2 = Texto2.text.toString().toInt()

                        val suma = num1 + num2

                        val resultado = findViewById<TextView>(R.id.editText3)
                        resultado.text = suma.toString()
                    } catch (e: NumberFormatException){
                     e.stackTrace
                    }
                }

                R.id.radioButtonSubstract -> {
                    try{
                        val num1 = Texto1.text.toString().toInt()
                        val num2 = Texto2.text.toString().toInt()

                        val resta = num1 - num2

                        val resultado = findViewById<TextView>(R.id.editText3)
                        resultado.text = resta.toString()
                    } catch (e: NumberFormatException){
                        e.stackTrace
                    }
                }
            }
        }
    }
}