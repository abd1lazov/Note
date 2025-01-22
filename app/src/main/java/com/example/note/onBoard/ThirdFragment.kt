package com.example.note.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.note.R
import com.example.note.databinding.FragmentOnBoardingBinding
import com.example.note.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding = FragmentThirdBinding.inflate(inflater,container, false)

        binding.btnStart.setOnClickListener{
            findNavController().navigate(R.id.action_onBoardingFragment_to_authFragment)
        }
        return binding.root
    }
}