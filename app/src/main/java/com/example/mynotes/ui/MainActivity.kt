package com.example.mynotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.mynotes.R
import com.example.mynotes.databinding.ActivityMainBinding
import com.example.mynotes.ui.add.AddFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<AddFragment>(R.id.fragmentContainer, "add")
        }
    }
}