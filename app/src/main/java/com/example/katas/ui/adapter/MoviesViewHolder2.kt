import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.katas.data.model.Movie2
import com.example.katas.databinding.ItemsMoviesInicioBinding
import com.example.katas.service.ApiService.Companion.IMAGE_URL

class MoviesViewHolder2(view: View): RecyclerView.ViewHolder(view){
    private val binding = ItemsMoviesInicioBinding.bind(view)

    fun render(MoviesModel2: Movie2) {
        binding.textTitleRating.text = MoviesModel2.title
        binding.textRating.text = MoviesModel2.rating

        val imageURL = IMAGE_URL + "w500" + MoviesModel2.posterPath

        Glide.with(binding.moviePoster.context)
            .load(imageURL)
            .into(binding.moviePoster)





    }
}