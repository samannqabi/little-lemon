package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    return (
            Column (modifier = Modifier.fillMaxSize()
                .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row  (modifier = Modifier

                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                    ){
                    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo"
                        , modifier = Modifier
                            .height(100.dp)
                            .width(250.dp)
                    )
                    Button(colors = ButtonColors(
                        containerColor = Color.White,
                        contentColor = Color.White,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Color.Gray
                    ),
                        onClick = {
                            navController.navigate("Profile")
                        }) {
                        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "Logo"
                            , modifier = Modifier
                                .height(80.dp)
                                .width(80.dp)
                                .padding(top = 10.dp),
                        )
                    }
                }
            }
            )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val navController = rememberNavController()
    Home(navController)
}