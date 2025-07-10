package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthDayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthDayCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingImage(
                        message = stringResource(R.string.birthday_text),
                        from = stringResource(R.string.signature_text),wish = stringResource(R.string.wish_text),
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun GreetingText(message:String,modifier: Modifier = Modifier,from : String,wish:String) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()) {
        Text(
            text = message,
            fontSize = 85.sp,
            color = Color.Black,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = wish,
            color = Color.Black,
            fontSize = 32.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center,

        )

        Text(
            text = from,
            color = Color.DarkGray,
            fontSize = 26.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}
@Composable
fun GreetingImage(message: String,from: String,wish: String,modifier: Modifier= Modifier){
val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.6F
        )
        GreetingText(message= message,from = from, wish = wish,modifier = Modifier
            .fillMaxSize()
            .padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthDayCardTheme {
        GreetingImage(message = stringResource(R.string.birthday_text),wish = stringResource(R.string.wish_text), from = stringResource(R.string.signature_text))
    }
}