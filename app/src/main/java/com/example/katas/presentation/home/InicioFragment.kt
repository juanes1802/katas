package com.example.katas.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.R
import com.example.katas.databinding.FragmentInicioBinding
import com.example.katas.domain.model.MovieHome
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InicioFragment : Fragment(R.layout.fragment_inicio) {
    private var _binding: FragmentInicioBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapterRated: MoviesAdapterTopRatedAndPopular
    private lateinit var adapterPopular: MoviesAdapterTopRatedAndPopular
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        moviesViewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        initRatingRecyclerView()
        initPopularRecyclerView()



        // observa los cambios  en la lista de peliculas
        configuredObservers()

        configuredLoad()


    }

    private fun configuredLoad() {
        moviesViewModel.loadMoviesPopular()
        moviesViewModel.loadMoviesRated()
    }

    private fun configuredObservers() {
        moviesViewModel.moviesPopular.observe(viewLifecycleOwner) { moviesPopular ->
            if(moviesPopular.isNotEmpty()) {
                adapterPopular.updateMovies(moviesPopular)

            }

        }
        moviesViewModel.moviesRated.observe(viewLifecycleOwner) { moviesRated ->
           if(moviesRated.isNotEmpty()){
               adapterRated.updateMovies(moviesRated)
           }
        }
    }


    private fun initPopularRecyclerView() {

        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapterPopular = MoviesAdapterTopRatedAndPopular { moviePopular -> onMovieClick(moviePopular) }
        binding.recyclerViewPopular.layoutManager = manager
        binding.recyclerViewPopular.adapter = adapterPopular
    }


    fun initRatingRecyclerView() {

        val manager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        adapterRated = MoviesAdapterTopRatedAndPopular { movieRating -> onMovieClick(movieRating) }
        binding.recyclerViewRating.layoutManager = manager
        binding.recyclerViewRating.adapter = adapterRated
    }

    fun onMovieClick(movie: MovieHome) {
        movie.id?.let { movieId ->
            val action = InicioFragmentDirections.actionPageInicioToPageDetail(movieId)
            findNavController().navigate(action)
            Log.d("HomeFragment ", "Navegando a DetalleFragment con movieId: $movieId")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


