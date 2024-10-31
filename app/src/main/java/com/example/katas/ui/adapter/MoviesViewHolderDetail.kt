import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katas.data.model.MovieDetalle
import com.example.katas.databinding.ItemsMoviesInicioBinding
import com.example.katas.service.ApiService.Companion.IMAGE_URL


class MoviesViewHolderDetail(view: View) : RecyclerView.ViewHolder(view) {
   val binding = ItemsMoviesInicioBinding.bind(view)



    fun bind(movie: MovieDetalle) {
        binding.textTitleRating.text = movie.title
        binding.textRating.text = movie.rating

        val imageURL = IMAGE_URL + "w500" + movie.posterPath

        Glide.with(binding.moviePoster.context)
            .load(imageURL)
            .into(binding.moviePoster)
    }
}