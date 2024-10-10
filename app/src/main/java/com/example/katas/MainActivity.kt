package com.example.katas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.adapter.MoviesAdapter
import com.example.katas.databinding.ActivityMainBinding
import com.example.katas.service.ApiInterface
import com.example.katas.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)
        getMovieData {
            initRecyclerVIew(it)
        }


    }



    private fun getMovieData(callback: (List<Movie >) -> Unit) {
        val apiService = ApiService.getInstance().create(ApiInterface::class.java)
        apiService.getMovies().enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                return callback(response.body()!!.results)
            }

            override fun onFailure(p0: Call<Movies>, p1: Throwable) {

            }

        })
    }

     fun initRecyclerVIew(movieList: List<Movie>  )  {
        val manager = LinearLayoutManager(this)
        binding.movieRecycler.layoutManager = manager

        binding.movieRecycler.adapter = MoviesAdapter(movieList)
    }
}






