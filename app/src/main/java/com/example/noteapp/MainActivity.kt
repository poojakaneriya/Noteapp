package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.noteapp.Database.RoomDB
import com.example.noteapp.Entity.NoteEntity

class MainActivity : AppCompatActivity() {

    lateinit var db: RoomDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = RoomDB.init(this)

        var model = NoteEntity("pooja", "Kaneriya","2004")

        db.note().addNote(model)
    }
}