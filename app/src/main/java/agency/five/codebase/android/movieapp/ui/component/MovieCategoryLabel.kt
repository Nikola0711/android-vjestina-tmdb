package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

sealed class MovieCategoryLabelTextViewState {
    class InputText(val text: String) : MovieCategoryLabelTextViewState()
    class ResourceText(@StringRes val textRes: Int) : MovieCategoryLabelTextViewState()
}

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState

)

@Composable
fun MovieCategoryLabel(
    movieCategoryLabelUiState: MovieCategoryLabelViewState,
    onItemClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable { onItemClick() }
            .width(intrinsicSize = IntrinsicSize.Max)

    ) {
        Text(
            text = when (movieCategoryLabelUiState.categoryText) {
                is MovieCategoryLabelTextViewState.InputText -> movieCategoryLabelUiState.categoryText.text
                is MovieCategoryLabelTextViewState.ResourceText -> stringResource(
                    movieCategoryLabelUiState.categoryText.textRes
                )
            },
            color = if (movieCategoryLabelUiState.isSelected) Color.Black else Color.Gray,

            )

        Spacer(
            modifier = Modifier
                .size(6.dp)
        )
        Divider(
            color = if (movieCategoryLabelUiState.isSelected) Color.Black else Color.Transparent,
            thickness = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun selectTextSource(movieCategoryLabelViewState: MovieCategoryLabelViewState): String {
    return when (val categoryText = movieCategoryLabelViewState.categoryText) {
        is MovieCategoryLabelTextViewState.InputText -> categoryText.text
        is MovieCategoryLabelTextViewState.ResourceText -> stringResource(id = categoryText.textRes)
    }
}

@Preview
@Composable
fun MovieCategoryLabelPreview() {
    val inputText = MovieCategoryLabelTextViewState.InputText("Movies")
    val stringRes = MovieCategoryLabelTextViewState.ResourceText(R.string.app_name)
    val inputAsRes = MovieCategoryLabelViewState(0, true, stringRes)
    val inputAsText = MovieCategoryLabelViewState(1, false, inputText)
    Row {
        MovieCategoryLabel(movieCategoryLabelUiState = inputAsRes)
        MovieCategoryLabel(movieCategoryLabelUiState = inputAsText)
    }


}
