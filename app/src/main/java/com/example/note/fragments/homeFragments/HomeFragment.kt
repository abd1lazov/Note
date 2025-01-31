package com.example.note.fragments.homeFragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.R
import com.example.note.databinding.FragmentHomeBinding
import com.example.note.fragments.homeFragments.adapter.RvAdapter
import com.example.note.fragments.homeFragments.noteModel.NoteModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: RvAdapter
    private val noteModel: ArrayList<NoteModel> = arrayListOf(

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_taskFragment)
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        initialize()
    }

    private fun loadData() {
        parentFragmentManager.setFragmentResultListener("Note", viewLifecycleOwner) { _, bundle ->

            if (bundle.containsKey("note") && bundle.containsKey("desc") && bundle.containsKey("timestamp")) {
                val taskText = bundle.getString("note")
                val descText = bundle.getString("desc")

                if (!taskText.isNullOrEmpty() && !descText.isNullOrEmpty()) {

                    val note = NoteModel(taskText, descText, "EEEE, dd MMMM yyyy")
                    noteModel.add(0, note)
                    if (::adapter.isInitialized) {
                        adapter.notifyItemInserted(0)
                    } else {
                        Log.e("AdapterError", "Adapter is not initialized!")
                    }
                }
            }
        }
    }

    private fun initialize() {
        adapter = RvAdapter(noteModel)
        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHome.adapter =adapter
    }
}