package com.example.noteapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.noteapp.Adepters.NoteAdapter
import com.example.noteapp.Database.RoomDB
import com.example.noteapp.Entity.NoteEntity
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.databinding.AddDialogBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {

    lateinit var db: RoomDB
    lateinit var binding: ActivityMainBinding
    lateinit var adapter : NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.init(this)

        initView()

    }

    private fun initView() {
        
        binding.add.setOnClickListener {
            addNoteDialog()
        }

        adapter = NoteAdapter(db.note().getNote())
        binding.note.layoutManager = GridLayoutManager(this,2)
        binding.note.adapter = adapter

    }

    private fun addNoteDialog() {
        var dialog =  Dialog(this)
        var bind = AddDialogBinding.inflate(layoutInflater)
        dialog.setContentView(bind.root)

        bind.submit.setOnClickListener {

            var title = bind.title.text.toString()
            var text = bind.text.text.toString()
            var format = SimpleDateFormat("DD/MM/YYYY hh:mm:ss a")
            var current = format.format(Date())

            var  date = NoteEntity(title,text, current)
            db.note().addNote(date)

            dialog.dismiss()
        }

        dialog.show()
    }

}