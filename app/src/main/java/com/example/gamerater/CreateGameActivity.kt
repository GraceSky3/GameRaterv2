package com.example.gamerater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.gamerater.database.AppDatabase
import com.example.gamerater.databinding.ActivityCreateGameBinding
import com.example.gamerater.model.Game

class CreateGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateGameBinding

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.aAdirbutton.setOnClickListener{
            val title = binding.titulo.text.toString()
            val category = binding.categ.text.toString()
            val plataform = binding.plataforma.text.toString()
            val review = binding.reseA.text.toString()

            val game = Game(
                title = title,
                category = category,
                plataform = plataform,
                review = review
            )

            db
                .gameDao()
                .save(game)

            finish()

            val intent = Intent(
                this,
                MainActivity::class.java
            )


            startActivity(intent)
        }
    }
}