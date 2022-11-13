package agency.five.codebase.android.movieapp.ui.component


import agency.five.codebase.android.movieapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier

) {
    val isFavorite = remember {
        mutableStateOf(false)
    }
    Image(
        painter = painterResource(id = if (isFavorite.value) R.drawable.ic_liked else R.drawable.ic_notliked),
        contentDescription = "Liked",
        modifier = modifier
            .padding(15.dp)
            .size(25.dp)
            .clickable { isFavorite.value = isFavorite.value.not() }


    )
}

@Preview(showBackground = true)
@Composable
fun FavoriteButtonPreview() {
    FavoriteButton()
}






