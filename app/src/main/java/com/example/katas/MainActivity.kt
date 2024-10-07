package com.example.katas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.adapter.MoviesAdapter
import com.example.katas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)
        initRecyclerVIew()


    }

    private fun initRecyclerVIew() {
        val manager = LinearLayoutManager(this)
        binding.movieRecycler.layoutManager = manager
        val moviesProvider = MoviesProvider()
        binding.movieRecycler.adapter = MoviesAdapter(moviesProvider.MoviesList) { dataMovies ->
            onItemSelected(dataMovies)


        }
    }

    private fun onItemSelected(movies: DataMovies) {
        Toast.makeText(this, movies.titulo, Toast.LENGTH_SHORT).show()
    }
}
