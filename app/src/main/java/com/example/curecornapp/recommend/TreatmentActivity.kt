package com.example.curecornapp.recommend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.curecornapp.databinding.ActivityTreatmentBinding
import com.example.curecornapp.recommend.treatmentDetails.DetailTreatmentBlight
import com.example.curecornapp.recommend.treatmentDetails.DetailTreatmentLeaf
import com.example.curecornapp.recommend.treatmentDetails.DetailTreatmentRust

class TreatmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTreatmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTreatmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLeaf.setOnClickListener {
            val intent = Intent(this, DetailTreatmentLeaf::class.java)
            startActivity(intent)
        }

        binding.btnBlight.setOnClickListener {
            val intent = Intent(this, DetailTreatmentBlight::class.java)
            startActivity(intent)
        }

        binding.btnRust.setOnClickListener {
            val intent = Intent(this, DetailTreatmentRust::class.java)
            startActivity(intent)
        }
    }
}