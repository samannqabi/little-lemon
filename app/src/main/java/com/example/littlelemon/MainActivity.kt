package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemon.ui.theme.LittleLemonTheme
import Onboarding
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}


@Composable
fun AppNavigation() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(("MyPrefs"), Context.MODE_PRIVATE)
    val isUserRegistered = !sharedPreferences.getString("firstName", "").isNullOrBlank()
    val startDestination = if (isUserRegistered) "Home" else "onBoarding"
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("onBoarding") {Onboarding(navController)}
        composable("Home") { Home(navController)}
        composable("Profile") { Profile(navController) }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {

}