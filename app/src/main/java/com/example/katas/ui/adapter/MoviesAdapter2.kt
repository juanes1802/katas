import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.katas.R

import com.example.katas.data.model.Movie2

class MoviesAdapter2(private val MoviesList2: List<Movie2>) :
    RecyclerView.Adapter<MoviesViewHolder2>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder2 {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder2(layoutInflater.inflate(R.layout.items_movies_inicio, parent, false))
    }

    override fun getItemCount(): Int = MoviesList2.size


    override fun onBindViewHolder(holder: MoviesViewHolder2, position: Int) {
        holder.render(MoviesList2[position])

    }

}