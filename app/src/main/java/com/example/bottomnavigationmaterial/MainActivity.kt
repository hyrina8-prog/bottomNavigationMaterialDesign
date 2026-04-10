package com.example.bottomnavigationmaterial



import Home
import Library
import Short
import Subscribe
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.*
import com.example.bottomnavigationmaterial.ui.theme.BottomNavigationMaterialTheme
import com.example.bottomnavigationmaterial.ui.theme.Pink
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BottomNavigationMaterialTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnNavBotSheet()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavBotSheet() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext
    val selection = remember { mutableStateOf(Icons.Default.Home) }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color.White,
                drawerShape = RoundedCornerShape(0.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(190.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bg),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),

                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "LumiFlix",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Pink
                        )
                        Text(
                            text = "enjoy your time in LumiFlix",
                            fontSize = 13.sp,
                            color = Pink.copy(alpha = 0.7f)
                        )
                    }
                }


                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = false,
                    icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Pink) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() } // បិទ Drawer វិញក្រោយចុច
                        navigationController.navigate(Screens.Home.screen)
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = "Setting") },
                    selected = false,
                    icon = { Icon(Icons.Default.Settings, contentDescription = null, tint = Pink) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Setting.screen) { popUpTo(0) }
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = "Share") },
                    selected = false,
                    icon = { Icon(Icons.Default.Share, contentDescription = null, tint = Pink) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Share.screen) { popUpTo(0) }
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = "About Us") },
                    selected = false,
                    icon = { Icon(Icons.Default.Person, contentDescription = null, tint = Pink) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.AboutUs.screen) { popUpTo(0) }
                    }
                )

                Divider(modifier = Modifier.padding(vertical = 8.dp))

                NavigationDrawerItem(
                    label = { Text(text = "Logout") },
                    selected = false,
                    icon = { Icon(Icons.Default.ExitToApp, contentDescription = null, tint = Pink) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        Toast.makeText(context, "Logged Out", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    ) {
        Scaffold(
            //for controll navigation
            topBar = {
                TopAppBar(
                    title = { Text(text = "Lumiflix") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Pink,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch { drawerState.open() }
                        }) {
                            Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu")
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar(containerColor = Pink) {
                    // Home
                    IconButton(
                        onClick = {
                            selection.value = Icons.Default.Home
                            navigationController.navigate(Screens.Home.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f).fillMaxHeight()
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home",
                                tint = if (selection.value == Icons.Default.Home) Color.White else Color.DarkGray,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Home",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (selection.value == Icons.Default.Home) Color.White else Color.DarkGray
                            )
                        }
                    }


                    // Short
                    IconButton(
                        onClick = {
                            selection.value = Icons.Default.PlayArrow
                            navigationController.navigate(Screens.Short.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f).fillMaxHeight()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Shorts",
                                tint = if (selection.value == Icons.Default.PlayArrow) Color.White else Color.DarkGray,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Shorts",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (selection.value == Icons.Default.PlayArrow) Color.White else Color.DarkGray
                            )
                        }
                    }



                    if (showBottomSheet){
                        ModalBottomSheet (onDismissRequest = { showBottomSheet = false},
                            sheetState = sheetState
                        ) {
                            Column(modifier = Modifier
                                .fillMaxSize()
                                .padding(18.dp),
                                verticalArrangement = Arrangement.spacedBy(20.dp)) {
                                BottomSheetItem(icon = Icons.Default.ThumbUp, title="Create a Post"){
                                    showBottomSheet= false
                                    navigationController.navigate(Screens.Post.screen){
                                        popUpTo(0)
                                    }
                                }

                                BottomSheetItem(icon = Icons.Default.Star, title="Add a Story"){
                                    Toast.makeText(context, "Story", Toast.LENGTH_SHORT).show()

                                }

                                BottomSheetItem(icon = Icons.Default.PlayArrow, title="Create a reels"){
                                    Toast.makeText(context, "Reels", Toast.LENGTH_SHORT).show()

                                }

                                BottomSheetItem(icon = Icons.Default.Favorite, title="Go Live"){
                                    Toast.makeText(context, "Live", Toast.LENGTH_SHORT).show()

                                }

                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        FloatingActionButton(onClick = { showBottomSheet = true}) {
                            Icon(Icons.Default.Add, contentDescription = null, tint = Pink)
                        }
                    }

                    // Subscribe
                    IconButton(
                        onClick = {

                            selection.value = Icons.Default.Person

                            navigationController.navigate(Screens.Subscribe.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f).fillMaxHeight()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Subscribe",

                                tint = if (selection.value == Icons.Default.Person) Color.White else Color.DarkGray,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Subscribe",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (selection.value == Icons.Default.Person) Color.White else Color.DarkGray
                            )
                        }
                    }

                    // Library
                    IconButton(
                        onClick = {
                            selection.value = Icons.Default.Favorite
                            navigationController.navigate(Screens.Library.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f).fillMaxHeight()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Library",
                                tint = if (selection.value == Icons.Default.Favorite) Color.White else Color.DarkGray,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Library",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = if (selection.value == Icons.Default.Favorite) Color.White else Color.DarkGray
                            )
                        }
                    }

                }
            }
        ) { paddingValues ->

            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen
            ) {
                composable(Screens.Home.screen) { Home()}
                composable(Screens.Short.screen) { Short()}
                composable(Screens.Subscribe.screen) { Subscribe()}
                composable(Screens.Library.screen) { Library()}
                composable(Screens.Share.screen) { Share() }
                composable(Screens.Setting.screen) { Setting() }
                composable(Screens.AboutUs.screen) { About_Us() }


            }
        }
    }

    }
    @Composable
    fun BottomSheetItem(icon: ImageVector, title: String, onClick: () -> Unit){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.clickable{ onClick()}
        ) {
            Icon(icon, contentDescription = null, tint = Pink)
            Text(text = title, color=Pink, fontSize = 22.sp)

        }

    }





//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BottomNavigationMaterialTheme {
//        Greeting("Android")
//    }
//}