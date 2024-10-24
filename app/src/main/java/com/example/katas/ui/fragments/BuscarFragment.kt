package com.example.katas

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.adapters.SearchViewBindingAdapter.OnQueryTextChange
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.util.query
import com.example.katas.adapter.MoviesAdapterSearch
import com.example.katas.data.model.MovieSearch
import com.example.katas.data.model.MoviesSearch
import com.example.katas.databinding.FragmentMoviesBinding
import com.example.katas.viewmodel.SearchViewModel


class BuscarFragment : Fragment(R.layout.fragment_movies) {


    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    lateinit var  adapter : MoviesAdapterSearch
    lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]




        // observa los cambios  en la lista de peliculas

        searchViewModel.filteredMovies.observe(viewLifecycleOwner){
            filteredMovies ->
            adapter.updateList(filteredMovies)
        }

        searchViewModel.loadMovies()

        searchViewModel.movies.observe(viewLifecycleOwner) { movies ->

            initRecyclerVIew(movies)
        }



        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {searchViewModel.filterMovies(it)}
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {searchViewModel.filterMovies(it)}
                return true
            }


        })

    }

    fun initRecyclerVIew(movieSearchList: List<MovieSearch>) {
        val manager = LinearLayoutManager(requireContext())
        adapter  = MoviesAdapterSearch(movieSearchList)
        binding.movieRecycler.layoutManager = manager

        binding.movieRecycler.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


} // del oncreate
