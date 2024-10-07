package gong.clouds.rick.woodenfish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gong.clouds.rick.woodenfish.ui.theme.RickwoodenfishTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickwoodenfishTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UI(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun UpdateImage(time:Int, modifier: Modifier = Modifier) {

    var imageDrawableId by remember { mutableIntStateOf(R.drawable.a) }

    LaunchedEffect(time) {
        imageDrawableId= R.drawable.a
//        Thread.sleep(2000L)
        delay(500)
        imageDrawableId=R.drawable.b

    }
    Image(
        painterResource(id = imageDrawableId),
        contentDescription = null,)
}

@Composable
fun UI(modifier: Modifier = Modifier) {
    var clicks by remember { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(Color.White),
    ){
        UpdateImage(clicks)
        Button(
            modifier=modifier.width(300.dp),
            onClick = {
                clicks++
            }) {
            Text(
                text="$clicks",
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                modifier = modifier
            )
        }
    }
}