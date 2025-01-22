package com.example.note.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.note.R
import com.example.note.databinding.FragmentOnBoardingBinding
import com.example.note.onBoard.adapter.ViewPagerAdapter

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnBoardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
             lifecycle
        )

        val viewPager = binding.viewPager

        viewPager.adapter = adapter

        val indicator = binding.dotsIndicator
        indicator.attachTo(viewPager)

        return binding.root
    }
}