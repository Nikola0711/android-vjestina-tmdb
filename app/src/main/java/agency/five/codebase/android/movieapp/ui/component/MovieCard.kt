package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


data class MovieCardViewState(
    val imageUrl: String?,
    val isFavorite: Boolean
)

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    movieCardViewState: MovieCardViewState,
    onMovieClick: () -> Unit = {},
    onFavoriteButtonClicked: () -> Unit = {}

) {
    Card(
        modifier = modifier.clickable { onMovieClick() },
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Box {
            AsyncImage(
                model = movieCardViewState.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()


            )
            FavoriteButton(
                modifier = Modifier.padding(MaterialTheme.spacing.small),
                isFavorite = false,
                onClick = onFavoriteButtonClicked


            )
        }


    }

}

@Preview
@Composable
fun MovieCardPreview() {
    val movie = MoviesMock.getMoviesList()[0]
    val movieCardViewState =
        MovieCardViewState(imageUrl = movie.imageUrl.toString(), isFavorite = false)

    val movieCardModifier = Modifier
        .padding(5.dp)
        .width(120.dp)
        .height(180.dp)

    MovieCard(
        movieCardViewState = movieCardViewState,
        modifier = movieCardModifier


    )
}
