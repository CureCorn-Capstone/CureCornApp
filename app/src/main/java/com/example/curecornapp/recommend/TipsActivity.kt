package com.example.curecornapp.recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.curecornapp.databinding.ActivityTipsBinding
import com.example.curecornapp.recommend.tipsDetails.DetailTips1
import com.example.curecornapp.recommend.tipsDetails.DetailTips2
import com.example.curecornapp.recommend.tipsDetails.DetailTips3

class TipsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCorn.setOnClickListener {
            val intent = Intent(this, DetailTips1::class.java)
            startActivity(intent)
        }

        binding.btnSoils.setOnClickListener {
            val intent = Intent(this, DetailTips2::class.java)
            startActivity(intent)
        }

        binding.btnPlanting.setOnClickListener {
            val intent = Intent(this, DetailTips3::class.java)
            startActivity(intent)
        }
    }
}