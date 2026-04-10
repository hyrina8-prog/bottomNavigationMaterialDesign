import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnavigationmaterial.R // ត្រូវប្រាកដថា R នេះត្រូវតាម package របស់អ្នក
import com.example.bottomnavigationmaterial.ui.theme.Pink

@Composable
fun Home() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(bottom = 20.dp)
    ) {

        item {
            Column(modifier = Modifier.padding(30.dp)) {
                Text(
                    text = "LumiFlix",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Pink
                )
                Spacer(modifier = Modifier.height(25.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.my_banner),
                        contentDescription = "Banner",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        //trending
        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Trending",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Pink
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    MovieCard(imageRes = R.drawable.img, height = 150.dp, modifier = Modifier.weight(1f))
                    MovieCard(imageRes = R.drawable.img_1, height = 150.dp, modifier = Modifier.weight(1f))
                    MovieCard(imageRes = R.drawable.img_2, height = 150.dp, modifier = Modifier.weight(1f))
                }
            }
        }
        //recommend
        item {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Recommended",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Pink
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    MovieCard(imageRes = R.drawable.img_3, height = 200.dp, modifier = Modifier.weight(1f))
                    MovieCard(imageRes = R.drawable.img_4,height = 200.dp, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Composable
fun MovieCard(
    imageRes: Int,
    height: androidx.compose.ui.unit.Dp,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(height),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}