package com.training.padelprime.presentation.screen.management

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.R
import com.training.padelprime.presentation.screen.management.components.Calendar
import com.training.padelprime.ui.theme.PadelPrimeTheme

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ManagementScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Calendar()

        Spacer(modifier = Modifier.height(20.dp))

        BookingsSection()

    }

}

@Composable
fun BookingsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Bookings",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 18.sp
            )

            Text(
                text = "13 Aug 2024",
                fontWeight = FontWeight.Light,
                color = Color.Gray,
                fontSize = 12.sp
            )

        }

        Spacer(modifier = Modifier.height(14.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 44.dp),
            verticalArrangement = Arrangement.spacedBy(11.dp)
        ) {
            items(7) {
                BookingsItem()
            }
        }
    }
}

@Composable
fun BookingsItem() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(Color.White.copy(alpha = 0.10f))
            .height(64.dp),

        ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            VerticalDivider(
                modifier = Modifier
                    .fillMaxHeight(),
                color = Color.Green,
                thickness = 3.dp
            )

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp)
                    .height(36.dp)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy((-10).dp),
            ) {

                Image(
                    painter = painterResource(id = R.drawable.iv_person),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                )
                Image(
                    painter = painterResource(id = R.drawable.iv_person2),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                )
                Image(
                    painter = painterResource(id = R.drawable.iv_person3),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                )
                Image(
                    painter = painterResource(id = R.drawable.iv_person4),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                )


            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(bottom = 10.dp, end = 10.dp, top = 6.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "05:00 AM",
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = "05:00 AM",
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                    )
            }


        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@PreviewLightDark
@Composable
private fun ManagementScreenPreview() {
    PadelPrimeTheme {
        ManagementScreen(navController = rememberNavController())
    }

}