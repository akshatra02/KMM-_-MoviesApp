package presentation.org.kmm.themoviesapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import utils.AsyncImagePainter

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    title: String,
    backdropPath: String,
    releaseDate: String
) {
    Card(
        modifier = modifier
            .width(250.dp)
            .height(400.dp)
            .padding(10.dp),
        elevation = 4.dp,
    ) {
        Column(
            modifier = modifier
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp),
                painter = AsyncImagePainter(backdropPath),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
            Text(
                text = title, style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                modifier = modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = releaseDate,
                style = MaterialTheme.typography.body1,
                modifier = modifier.padding(horizontal = 10.dp)
            )
        }

    }

}