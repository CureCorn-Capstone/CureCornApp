package com.example.curecornapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.curecornapp.R
import com.example.curecornapp.databinding.FragmentHomeBinding
import com.example.curecornapp.recommend.DrugActivity
import com.example.curecornapp.recommend.TipsActivity
import com.example.curecornapp.recommend.TreatmentActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTreat.setOnClickListener{
            val intent = Intent(requireActivity(), TreatmentActivity::class.java)
            startActivity(intent)
        }

        binding.btnObat.setOnClickListener{
            val intent = Intent(requireActivity(), DrugActivity::class.java)
            startActivity(intent)
        }

        binding.btnTips.setOnClickListener{
            val intent = Intent(requireActivity(), TipsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}