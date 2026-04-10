import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnavigationmaterial.R // ពិនិត្យឈ្មោះ package របស់អ្នក
import com.example.bottomnavigationmaterial.ui.theme.Pink

@Composable
fun Subscribe() {

    val creators = listOf(R.drawable.s3, R.drawable.s4, R.drawable.s7)

    val uploads = listOf(R.drawable.s5, R.drawable.s6)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        item {
            Column(modifier = Modifier.padding(80.dp)) {
                Text(
                    text = "Subscriptions",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Pink
                )
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(creators) { imageRes ->
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.LightGray, CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
        item {
            PaddingValues(horizontal = 16.dp).let {
                Text(
                    text = "Latest Uploads",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Pink,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                )
            }
        }

        items(uploads) { videoImage ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(0.dp),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Image(
                    painter = painterResource(id = videoImage),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}