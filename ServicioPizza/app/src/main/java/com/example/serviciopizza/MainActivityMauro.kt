package com.example.serviciopizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.serviciopizza.databinding.ActivityMainMauroBinding

class MainActivityMauro : AppCompatActivity() {

    private lateinit var binding: ActivityMainMauroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainMauroBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

    }
}