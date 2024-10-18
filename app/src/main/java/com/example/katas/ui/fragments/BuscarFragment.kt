package com.example.katas

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.adapter.MoviesAdapter
import com.example.katas.data.model.Movie
import com.example.katas.data.model.Movies
import com.example.katas.databinding.FragmentMoviesBinding
import com.example.katas.service.ApiInterface
import com.example.katas.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BuscarFragment : Fragment(R.layout.fragment_movies) {


    private var  _binding : FragmentMoviesBinding? = null
    private val   binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovieData{
            initRecyclerVIew(it)


        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = ApiService.getInstance().create(ApiInterface::class.java)
        apiService.getMovies().enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.isSuccessful && response.body() != null) {
                    callback(response.body()!!.results)
                }

            }




            override fun onFailure(p0: Call<Movies>, p1: Throwable) {

            }

        })
    }
    fun initRecyclerVIew(movieList: List<Movie>  )  {
        val manager = LinearLayoutManager(requireContext())
        binding.movieRecycler.layoutManager = manager

        binding.movieRecycler.adapter = MoviesAdapter(movieList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}
