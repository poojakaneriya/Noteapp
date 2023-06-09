package com.example.noteapp.Adepters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noteapp.Entity.NoteEntity
import com.example.noteapp.databinding.NoteItemBinding

class NoteAdapter(note: List<NoteEntity>) : Adapter<NoteAdapter.NotesHolder>() {
    var  note = note

    class NotesHolder(itemView: NoteItemBinding) : ViewHolder(itemView.root){

        var binding = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        var  binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotesHolder(binding)
    }

    override fun getItemCount(): Int {
        return note.size
          }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {

        holder.binding.apply {
            note.get(position).apply {
                titlent.text =  title
                textnt.text = text
            }
        }

    }

    fun update(note: List<NoteEntity>){
        this.note = note
        notifyDataSetChanged()
    }
}