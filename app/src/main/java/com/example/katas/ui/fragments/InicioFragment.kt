package com.example.katas.ui.fragments

import MoviesAdapter2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.R
import com.example.katas.data.model.Movie2
import com.example.katas.data.model.Movies
import com.example.katas.data.model.Movies2
import com.example.katas.data.network.ApiInterface2
import com.example.katas.databinding.FragmentInicioBinding
import com.example.katas.service.ApiInterface
import com.example.katas.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InicioFragment : Fragment(R.layout.fragment_inicio) {
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMovieData2 { initRecyclerVIew2(it) }
    }

    private fun getMovieData2(callback: (List<Movie2>) -> Unit) {
        val apiService = ApiService.getInstance().create(ApiInterface2::class.java)
        apiService.getMovies2().enqueue(object : Callback<Movies2> {
            override fun onResponse(call: Call<Movies2>, response: Response<Movies2>) {
                if (response.isSuccessful && response.body() != null) {
                    callback(response.body()!!.results)
                }
            }

            override fun onFailure(call: Call<Movies2>, t: Throwable) {

            }
        })
    }

    fun initRecyclerVIew2(movieList: List<Movie2>) {

        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.layoutManager = manager

        // Asigna el adapter al RecyclerView
        binding.recyclerView.adapter = MoviesAdapter2(movieList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}