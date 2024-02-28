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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
fun Preview() {
    // Use MaterialTheme for consistent styling and easy theme switching
    MaterialTheme {
        // Surface is a composable provided by Material Design that gives you a background
        // according to the theme's color scheme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background // Set the background color to white or theme default
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp), // Add padding around the Column for aesthetics
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "LOGIN",
                    style = MaterialTheme.typography.headlineMedium // Set the font size and style
                )
                Spacer(modifier = Modifier.height(32.dp)) // Add space between elements

                // Username TextField
                OutlinedTextField(
                    value = "", // This should be tied to a state variable in a real app
                    onValueChange = {}, // Handle updates to the value
                    label = { Text("Username") }, // Label which appears when the TextField is empty
                    singleLine = true // Makes the TextField a single line input
                )
                Spacer(modifier = Modifier.height(16.dp)) // Add space between elements

                // Password TextField
                OutlinedTextField(
                    value = "", // This should be tied to a state variable in a real app
                    onValueChange = {}, // Handle updates to the value
                    label = { Text("Password") }, // Label which appears when the TextField is empty
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(), // Obscure the password input
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) // Set the keyboard type to password
                )
                Spacer(modifier = Modifier.height(24.dp)) // Add space between elements

                // Login Button
                Button(
                    onClick = { /* Handle the login logic here */ },
                    // Modifier to set the width of the button to take the max width available
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("LOGIN")
                }

                // Text to navigate to the Sign Up screen or forgot password
                TextButton(onClick = { /* Navigate to sign up or forgot password */ }) {
                    Text("Don't have an account? Sign up", color = MaterialTheme.colorScheme.primary) // Set the text color to the primary color of the theme
                }
            }
        }
    }
}
