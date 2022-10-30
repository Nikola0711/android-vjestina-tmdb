package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


sealed class MovieCategoryLabelTextViewState{
    class InputText(val text: String): MovieCategoryLabelTextViewState()
    class ResourceText(@StringRes val textRes: Int): MovieCategoryLabelTextViewState()

}
data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState

)

@Composable
fun MovieCategoryLabel(
    movieCategoryLabelViewState: MovieCategoryLabelViewState
){
    if(movieCategoryLabelViewState.isSelected){
        SelectedText(movieCategoryLabelViewState)
    }
    else{
        UnselectedText(movieCategoryLabelViewState)
    }

}

@Composable
fun SelectedText(
    movieCategoryLabelViewState: MovieCategoryLabelViewState,
    modifier: Modifier=Modifier

){
    val categoryText=movieCategoryLabelViewState.categoryText
    Column {
        Text(
            text =when(categoryText){
                is MovieCategoryLabelTextViewState.InputText -> categoryText.text
                is MovieCategoryLabelTextViewState.ResourceText -> stringResource(id = categoryText.textRes)
            },
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
        )
        Spacer(modifier = modifier.size(5.dp))
        Divider(color = Color.Black, thickness = 3.dp, modifier = modifier.fillMaxWidth())

    }

}

@Composable
fun UnselectedText(
    movieCategoryLabelViewState: MovieCategoryLabelViewState,
    modifier: Modifier=Modifier
) {
    val categoryText = movieCategoryLabelViewState.categoryText
    Text(
        text = when (categoryText) {
            is MovieCategoryLabelTextViewState.InputText -> categoryText.text
            is MovieCategoryLabelTextViewState.ResourceText -> stringResource(id = categoryText.textRes)
        },
        color=Color.Gray,
        fontSize = 15.sp,



    )


}
@Preview
@Composable
fun MovieCategoryLabelPreview(){
    val inputText=MovieCategoryLabelTextViewState.InputText("Movies")
    val stringRes=MovieCategoryLabelTextViewState.ResourceText(R.string.app_name)
    val viewState1= MovieCategoryLabelViewState(2,false, inputText)
    val viewState2=MovieCategoryLabelViewState(1, true, stringRes)
    MovieCategoryLabel(movieCategoryLabelViewState = viewState2)
   
}