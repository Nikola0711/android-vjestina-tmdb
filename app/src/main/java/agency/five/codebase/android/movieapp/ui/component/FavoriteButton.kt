package agency.five.codebase.android.movieapp.ui.component


import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.Blue
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onClick: () -> Unit


) {


    Image(
        painter = painterResource(id = if (isFavorite) R.drawable.ic_liked else R.drawable.ic_notliked),
        contentDescription = "Liked",
        modifier = modifier
            .clickable { onClick() }
            .background(
                color = Blue.copy(alpha = 0.6f),
                shape = CircleShape
            )
            .padding(MaterialTheme.spacing.small)


    )
}

@Preview(showBackground = true)
@Composable
fun FavoriteButtonPreview() {
    val favButtonModifier = Modifier
        .padding(10.dp)
        .size(28.dp)

    FavoriteButton(onClick = {}, isFavorite = false, modifier = favButtonModifier)
}






