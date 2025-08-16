import android.content.Context
import android.preference.PreferenceActivity.Header
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R
import org.w3c.dom.Text
import java.util.Objects


@Composable
fun Onboarding(navController: NavController) {
    var firstName by remember { mutableStateOf("")}
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(("MyPrefs"), Context.MODE_PRIVATE)
    return (
            Column (modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Column (modifier = Modifier.padding(16.dp)) {
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
                        text = "Let's get to know you",
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
                    TextField(modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = Color.Gray)
                        ,
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                        ),
                        value = firstName, onValueChange = {
                                input ->
                            firstName = input.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase() else it.toString()
                            }
                        })
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Text(fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        text = "Last name")
                    TextField(modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = Color.Gray)
                        ,
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                        ),
                        value = lastName, onValueChange = {
                                input ->
                            lastName = input.replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase() else it.toString()
                            }
                        },

                    )
                    Spacer(modifier = Modifier.padding(vertical = 10.dp))
                    Text(fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        text = "Email")
                    TextField(modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 1.dp, color = Color.Gray)
                        ,
                        colors = TextFieldDefaults.colors(focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                        ),

                        value = email, onValueChange = {email = it})
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
                           if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                               Toast.makeText(context, "Please fill all the fields!", Toast.LENGTH_LONG).show()
                           } else{
                               sharedPreferences.edit().apply {
                                   putString("firstName", firstName)
                                   putString("lastName", lastName)
                                   putString("email", email)
                                   apply()
                               }
                               Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
                               navController.navigate("Home")
                           }
                        }) {
                        Text(text = "Register")
                    }
                }

            }
            )
}


@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    val navController = rememberNavController()
    Onboarding(navController = navController)
}
