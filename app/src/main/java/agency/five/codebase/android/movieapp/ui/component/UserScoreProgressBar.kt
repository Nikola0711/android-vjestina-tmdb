package agency.five.codebase.android.movieapp.ui.component


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserScoreProgressBar(
    score: Float,
    modifier: Modifier = Modifier,
    radius: Dp = 20.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 5.dp,
    animDuration: Int = 1000,
) {
    val animationPlayed = remember { mutableStateOf(false) }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed.value) score else 0f,
        animationSpec = tween(
            durationMillis = animDuration
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed.value = true
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(radius * 2f)
    ) {
        Canvas(
            modifier = modifier
                .padding(5.dp)
                .size(radius * 2f)
        ) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )

        }
        Text(
            text = (score * 10f).toString(),
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold

        )
    }

}

@Preview(showBackground = true)
@Composable
fun UserScoreProgressBarPreview() {
    UserScoreProgressBar(score = 0.9f)
}