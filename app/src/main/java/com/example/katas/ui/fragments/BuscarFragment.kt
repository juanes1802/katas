package com.example.katas

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.katas.adapter.MoviesAdapterSearch
import com.example.katas.data.model.MovieSearch
import com.example.katas.databinding.FragmentMoviesBinding
import com.example.katas.viewmodel.SearchViewModel


class BuscarFragment : Fragment(R.layout.fragment_movies) {


    private var  _binding : FragmentMoviesBinding? = null
    private val   binding get() = _binding!!
    lateinit var  searchViewModel : SearchViewModel

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

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        // observa los cambios  en la lista de peliculas

        searchViewModel.movies.observe(viewLifecycleOwner){
            movies -> initRecyclerVIew(movies)
        }
        // iniciar la carga de datos
        searchViewModel.loadMovies()

    }






    fun initRecyclerVIew(movieSearchList: List<MovieSearch>  )  {
        val manager = LinearLayoutManager(requireContext())
        binding.movieRecycler.layoutManager = manager

        binding.movieRecycler.adapter = MoviesAdapterSearch(movieSearchList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




} // del oncreate
