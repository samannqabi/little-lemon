package com.example.littlelemon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Details(navController: NavController) {
    return (
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Details Screen")
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Go back Home")
                }
                Button(onClick = {
                    navController.navigate("onBoarding")
                }) {
                    Text(text = "Go to onBoarding")
                }
            }
            )
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    val navController = rememberNavController()
    Details(navController)
}