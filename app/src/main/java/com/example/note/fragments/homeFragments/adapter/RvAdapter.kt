package com.example.note.fragments.homeFragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.note.R
import com.example.note.databinding.ItemHomeBinding
import com.example.note.fragments.homeFragments.noteModel.NoteModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class RvAdapter(private val notes: ArrayList<NoteModel>) :
    RecyclerView.Adapter<RvAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
//        fun bind(note: NoteModel) {
            val tvTimestamp: TextView = itemView.findViewById(R.id.tv_date)
            val tvTask: TextView = itemView.findViewById(R.id.tv_title)
            val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
//            binding.cardView.setCardBackgroundColor(note.backgroundColor)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapter.NotesViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RvAdapter.NotesViewHolder, position: Int) {
        val note = notes[position]
        holder.tvTask.text = note.title
        holder.tvDesc.text = note.description

        val formattedTime = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date(note.timeAndDate))
        holder.tvTimestamp.text = formattedTime
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}