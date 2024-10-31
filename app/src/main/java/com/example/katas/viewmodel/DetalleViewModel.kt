import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katas.data.model.MovieDetalle
import com.example.katas.data.network.ApiInterfaceDetalle
import com.example.katas.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class DetalleViewModel : ViewModel() {
    private val apiService = ApiService.getInstance().create(ApiInterfaceDetalle::class.java)
    private val _recommendations = MutableLiveData<List<MovieDetalle>>()
    val recommendations: LiveData<List<MovieDetalle>> get() = _recommendations
    private val _movieDetails = MutableLiveData<MovieDetalle>()
    val movieDetails: LiveData<MovieDetalle> get() = _movieDetails

    fun fetchRecommendations(movieId: Int) {
        viewModelScope.launch {
            try {
                val response = apiService.getMovieRecomendations(movieId)
                if (response.isSuccessful) {
                    val results = response.body()?.results ?: emptyList()
                    Log.d("DetalleViewModel", "Recomendaciones obtenidas: $results")
                    _recommendations.postValue(results)
                } else {
                    Log.e("DetalleViewModel", "Error en la respuesta: ${response.code()} - ${response.message()}")
                }
            } catch (e: IOException) {
                Log.e("DetalleViewModel", "Error de red: ${e.message}")
            } catch (e: HttpException) {
                Log.e("DetalleViewModel", "Error HTTP: ${e.message()}")
            } catch (e: Exception) {
                Log.e("DetalleViewModel", "Error desconocido: ${e.message}")
            }
        }
    }

    fun fetchMovieDetails(movieId: Int){
        viewModelScope.launch {
            val response = apiService.getMovieDetails(movieId)
            if (response.isSuccessful){
                _movieDetails.postValue(response.body())
            }else {
                Log.e("DetalleViewModel", "Error: ${response.code()} - ${response.message()}")
            }
        }
    }
}
