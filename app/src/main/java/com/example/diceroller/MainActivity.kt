package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class FitnessApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FitnessTrackerApp()
                }
            }
        }
    }
}

@Preview // test comment
@Composable
fun FitnessTrackerApp() {
    var steps by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Fitness Tracker App", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { steps += 100 },
        ) {
            Text(text = "Press To Continue")
        }

        Spacer(modifier = Modifier.height(16.dp))

//        Image(
//            painter = painterResource(id = R.drawable.ic_walking),
//            contentDescription = "Walking Icon",
//            modifier = Modifier.size(100.dp)
//        )
    }
}