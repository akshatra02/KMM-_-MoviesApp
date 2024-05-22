package utils

import androidx.compose.runtime.Composable
import coil3.compose.LocalPlatformContext
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

@Composable
fun AsyncImagePainter(
    imageUrl: String
) = rememberAsyncImagePainter(
    model = ImageRequest
        .Builder(LocalPlatformContext.current)
        .data(IMAGE_BASE_URL+imageUrl)
        .build()
)
