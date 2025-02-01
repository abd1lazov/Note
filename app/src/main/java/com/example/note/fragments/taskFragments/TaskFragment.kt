package com.example.note.fragments.taskFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.fragment.findNavController
import com.example.note.R
import com.example.note.databinding.FragmentTaskBinding
import com.example.note.fragments.homeFragments.noteModel.NoteModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TaskFragment : Fragment() {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)

//        binding.btnBack.setOnClickListener {
//            findNavController().navigate(R.id.action_taskFragment_to_homeFragment)
//        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getCurrentTime()
        sendData()
    }

    private fun sendData() {
        binding.btnBack.setOnClickListener {

            val taskText = binding.etTitle.text.toString().trim()
            val descText = binding.etDesc.text.toString().trim()
            val timeText = binding.etDateAndTime.text.toString().trim()

            if (taskText.isNotEmpty() && descText.isNotEmpty() && timeText.isNotEmpty()) {
                val timeStamp = getCurrentTime()

                val bundle = Bundle().apply {
                    putString("note", taskText)
                    putString("desc", descText)
                    putString("timestamp", timeStamp)
                }
                parentFragmentManager.setFragmentResult("Note", bundle)
            }

            findNavController().popBackStack()

            binding.etTitle.text.clear()
            binding.etDesc.text.clear()
            binding.etDateAndTime.text.clear()
        }
    }

    private fun getCurrentTime(): String {
        val timestamp: Long = System.currentTimeMillis()
        val formattedDate =
            SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date(timestamp))

        binding.etDateAndTime.setText(formattedDate)
        return formattedDate
    }
}