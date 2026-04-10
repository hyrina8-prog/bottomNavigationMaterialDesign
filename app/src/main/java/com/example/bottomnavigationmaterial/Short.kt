import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnavigationmaterial.R // ពិនិត្យ Package របស់អ្នក

@Composable
fun Short() {

    val shortImages = listOf(
        R.drawable.s1,
        R.drawable.s2
    )

    val pagerState = rememberPagerState(pageCount = { shortImages.size })

    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {

        //For scroll
        VerticalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->

            ShortItem(imageId = shortImages[page], pageNum = page + 1)
        }
    }
}

@Composable
fun ShortItem(imageId: Int, pageNum: Int) {
    Box(modifier = Modifier.fillMaxSize()) {


        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.6f)),
                        startY = 600f
                    )
                )
        )


        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
                .padding(bottom = 60.dp) //
        ) {
            Text(text = "@Che_zzy", color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = "Short video $pageNum #Shorts #Kon cute cute", color = Color.White, fontSize = 14.sp)
        }


        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ShortAction(Icons.Default.Favorite, "5000")
            ShortAction(Icons.Default.Share, "Share")
            ShortAction(Icons.Default.MoreVert, "")
        }
    }
}

@Composable
fun ShortAction(icon: ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = {  }) {
            Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
        }
        if (label.isNotEmpty()) {
            Text(text = label, color = Color.White, fontSize = 12.sp)
        }
    }
}