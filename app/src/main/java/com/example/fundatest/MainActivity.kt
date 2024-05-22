package com.example.fundatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFilm: RecyclerView
    private val list = ArrayList<Film>()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilm = findViewById(R.id.rv_film)
        rvFilm.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Film> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataRate = resources.getStringArray(R.array.data_rate)
        val dataCast =  resources.getStringArray(R.array.cast)
        val listHero = ArrayList<Film>()
        for (i in dataName.indices) {
            val hero = Film(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataRate[i],dataCast[i])
            listHero.add(hero)
        }
        dataPhoto.recycle() // Memastikan untuk mendaur ulang TypedArray setelah digunakan
        return listHero
    }

    private fun showRecyclerList() {
        rvFilm.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListFilmAdapter(list)
        rvFilm.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListFilmAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Film) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(hero: Film) {
        val intent = Intent(this, DetailFilm::class.java)
        intent.putExtra("film", hero) // Mengirim objek Film yang dipilih ke DetailFilm Activity
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
