package com.example.curecornapp.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.curecornapp.R

class startPage : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)

        val btnMove: Button = findViewById(R.id.startButton)
        btnMove.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.startButton -> {
                val RegisIntent = Intent(this@startPage, Register::class.java)
                startActivity(RegisIntent)
            }
        }
    }
}