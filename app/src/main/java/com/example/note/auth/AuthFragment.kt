package com.example.note.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.note.R
import com.example.note.databinding.FragmentAuthBinding
import com.example.note.databinding.FragmentThirdBinding

class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)

        binding.btnAuth.setOnClickListener {
            findNavController().navigate(R.id.action_authFragment_to_homeFragment)
        }
        return binding.root
    }
}