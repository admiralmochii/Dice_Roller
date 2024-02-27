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
import androidx.navigation.NavController
import com.example.diceroller.ui.theme.DiceRollerTheme

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class FitnessApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitnessAppNavigation()
        }
    }
}

@Composable
fun FitnessAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "FitnessTrackerApp") {
        composable("FitnessTrackerApp") {
            FitnessTrackerApp(navController)
        }
        composable("LoginPage") {
            LoginPage()
        }
    }
}
// @Preview // test comment
@Composable
fun FitnessTrackerApp(navController: NavController) {
    var steps by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Fitness Tracker App", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("LoginPage") },
        ) {
            Text(text = "Press To Continue")
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}
@Composable
fun LoginPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Login Page", fontSize = 24.sp)
    }
}

@Preview // test comment
@Composable
fun PreviewFitnessTrackerApp() {
    FitnessTrackerApp(rememberNavController())
}

@Preview
@Composable
fun PreviewLoginPage() {
    LoginPage()
}