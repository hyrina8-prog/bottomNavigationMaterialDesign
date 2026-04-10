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
import com.example.bottomnavigationmaterial.R
import com.example.bottomnavigationmaterial.ui.theme.Pink

@Composable
fun Library() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
    ) {
        item {
            Text(
                text = "My Library",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Pink,

                modifier = Modifier.padding(top = 8.dp, bottom = 20.dp, start = 4.dp)
            )
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                LibraryRow(img1 = R.drawable.m3, img2 = R.drawable.m4)
                LibraryRow(img1 = R.drawable.m1, img2 = R.drawable.m2)
            }
        }
    }
}

@Composable
fun LibraryRow(img1: Int, img2: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LibraryCard(imageRes = img1, modifier = Modifier.weight(1f))
        LibraryCard(imageRes = img2, modifier = Modifier.weight(1f))
    }
}

@Composable
fun LibraryCard(imageRes: Int, modifier: Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(280.dp),
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