package com.example.introtocompose

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}


@Composable
fun MyApp(){
    val moneyC = remember {
        mutableIntStateOf(0);
    }
    IntroToComposeTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
            /*Box(
                modifier = Modifier.fillMaxSize(), // Fills the screen
                contentAlignment = Alignment.Center, // Centers the circle within the screen
            ){
                CreateCircle()
            }*/

            Column (verticalArrangement = Arrangement.Center, horizontalAlignment =  Alignment.CenterHorizontally){
               Text("$${moneyC.intValue}", style = TextStyle(fontSize = 39.sp), color = Color.White, fontWeight = FontWeight.ExtraBold)

                Spacer(modifier = Modifier.height(30.dp))

                CreateCircle(moneyCT = moneyC.intValue){ increment->
                    moneyC.intValue += increment
                }
                Spacer(modifier = Modifier.height(30.dp))
                if(moneyC.intValue > 25){
                    Text("Lots of money!")
                }
            }

        }
    }
}



@Composable
fun CreateCircle(moneyCT: Int = 0, updateMoneyCounter: (Int) -> Unit ){

    val moneyD = remember {
        mutableIntStateOf(0);
    }

    var moneyCounter by remember {
        mutableIntStateOf(0);
    }
    Card(modifier = Modifier
        .padding(3.dp)
        .size(100.dp)
        .clickable {
            moneyCounter += 1;
            moneyD.intValue += 1;
            updateMoneyCounter(1) // Call the update function to increase total money count

            Log.d("check", "CreateCircle: Tap$moneyCounter")
        }, shape = CircleShape, elevation = CardDefaults.cardElevation(8.dp)) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
            Text("${moneyD.intValue} Tap $moneyCounter", modifier = Modifier)
        }


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroToComposeTheme {
        MyApp()
    }
}