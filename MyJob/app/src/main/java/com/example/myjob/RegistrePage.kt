package com.example.myjob

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun RegisterPage(navController: NavController){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(
                color = Color.Transparent,
            )
            .padding(bottom = 40.dp)
    )
    {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter),

            )
        {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),

                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    text = "Create an Account",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.displayMedium,
                    color = Color(0xFF0978f6),
                )
                Spacer(modifier = Modifier.padding(3.dp))
                SimpleOutlinedTextFieldSample()
                Spacer(modifier = Modifier.padding(3.dp))
                SimpleOutlinedTextFieldSample()
                Spacer(modifier = Modifier.padding(3.dp))
                SimpleOutlinedTextFieldSample()
                Spacer(modifier = Modifier.padding(3.dp))
                SimpleOutlinedPasswordTextField()
                Spacer(modifier = Modifier.padding(3.dp))
                SimpleOutlinedPasswordTextField()

                Spacer(modifier = Modifier.padding(18.dp))
                val gradientColor = listOf(Color( 0xFF0978f6), Color(0xff00b0ff))
                val cornerRadius = 16.dp

                CreateAccountButton(
                    gradientColors = gradientColor,
                    cornerRadius = cornerRadius,
                    nameButton = "Create Account",
                    roundedCornerShape = RoundedCornerShape(topStart = 30.dp,bottomEnd = 30.dp)
                )
                Spacer(modifier = Modifier.padding(3.dp))
            }
        }

    }

}
@Composable
private fun CreateAccountButton(
    gradientColors : List<Color>,
    cornerRadius: Dp,
    nameButton : String,
    roundedCornerShape: RoundedCornerShape
){
    androidx.compose.material3.Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp),
        onClick = {
            //your code
        },

        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors),
                    shape = roundedCornerShape
                )
                .clip(roundedCornerShape)

                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material3.Text(
                text = nameButton,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}
