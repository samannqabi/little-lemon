package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Profile(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("firstName", null)
    val lastName = sharedPreferences.getString("lastName", null)
    val email = sharedPreferences.getString("email", null)
    return Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start) {
        Row {
            Button(
                modifier = Modifier
                .width(80.dp)
                    .padding(top = 20.dp),
                colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Gray
            ),
                onClick = {
                    navController.popBackStack()
                }) {
                Image(modifier = Modifier
                    .height(40.dp)
                    .width(100.dp),
                    painter = painterResource(id = R.drawable.back), contentDescription = "Back Icon")
            }
                Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Logo"
                    , modifier = Modifier
                        .height(100.dp)
                        .width(200.dp)
                )

        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(bottom = 20.dp)
            .background(Color(0xFF495E57)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${firstName}'s Profile",
                color = Color.White,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        Column (
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                text = "Personal information")
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            Text(fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                text = "First name")
            if (firstName != null) {
                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Gray),
                    colors = TextFieldDefaults.colors(focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    value = firstName, enabled = false, onValueChange = {})
            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                text = "Last name")
            if (lastName != null) {
                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Gray),
                    colors = TextFieldDefaults.colors(focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    value = lastName, enabled = false, onValueChange = {},

                    )
            }
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            Text(fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                text = "Email")
            if (email != null) {
                TextField(modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Gray),
                    colors = TextFieldDefaults.colors(focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),

                    value = email, enabled = false, onValueChange = {})
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(modifier = Modifier
                .fillMaxWidth(),

                colors = ButtonColors(
                    containerColor = Color(0xFFF4CE14),
                    disabledContainerColor = Color.Gray,
                    contentColor = Color.Black,
                    disabledContentColor = Color.Cyan
                ),
                onClick = {
                    sharedPreferences.edit().clear().apply()
                    Toast.makeText(context, "You are logged out", Toast.LENGTH_SHORT).show()
                    navController.navigate("onBoarding")
                }) {
                Text(text = "Logout")
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    Profile(navController)
}