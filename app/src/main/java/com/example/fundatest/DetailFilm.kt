package com.example.fundatest

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DetailFilm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_film)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true )

        supportActionBar!!.title = "Detail Movie"

        val film = intent.getParcelableExtra<Film>("film")
        if (film != null) {
            val textView = findViewById<TextView>(R.id.DetailFilmTv)
            val desc = findViewById<TextView>(R.id.DetailDesc)
            val imageView = findViewById<ImageView>(R.id.DetailFilmIv)
            val ratetv = findViewById<TextView>(R.id.rate)
            val casttv = findViewById<TextView>(R.id.cast)

            textView.text = film.name
            desc.text=film.description
            ratetv.text=film.rate
            casttv.text=film.cast
            imageView.setImageResource(film.photo)

            val share = findViewById<FloatingActionButton>(R.id.action_share)
            share.setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_TEXT, ("Kamu telah klik tombol share"))
                intent.type = "text/plain"
                startActivity(Intent.createChooser(intent,"Share item"))
            }
            val like = findViewById<FloatingActionButton>(R.id.action_like)
            like.setOnClickListener{
                Toast.makeText(this,"kamu sudah klik tombol like", Toast.LENGTH_SHORT).show()
            }
            val comment = findViewById<FloatingActionButton>(R.id.action_comment)
            comment.setOnClickListener{
                Toast.makeText(this,"kamu sudah klik tombol comment", Toast.LENGTH_SHORT).show()
            }


        }
    }
}
