package com.training.padelprime.presentation.screen.management

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
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.R
import com.training.padelprime.ui.theme.PadelPrimeTheme

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
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Bookings",
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "13 Aug 2024",
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )

        }

        Spacer(modifier = Modifier.height(14.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
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
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFF303234).copy(alpha = 0.70f))
            .height(64.dp),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy((-8).dp),
            ) {

                Image(
                    painter = painterResource(id = R.drawable.iv_person),
                    contentDescription = null,
                    modifier = Modifier
                        .size(38.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.iv_person2),
                    contentDescription = null,
                    modifier = Modifier
                        .size(38.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.iv_person3),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = (-10).dp)
                        .size(38.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.iv_person4),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(x = (-10).dp)
                        .size(38.dp)
                )


            }

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = "05:00 AM",
                    fontWeight = FontWeight.Thin,
                    fontSize = 12.sp
                )
                Text(
                    text = "05:00 AM",
                    fontWeight = FontWeight.Thin,
                    fontSize = 12.sp
                )
            }


        }
    }
    Spacer(modifier = Modifier.height(11.dp))
}

@PreviewLightDark
@Composable
private fun ManagementScreenPreview() {
    PadelPrimeTheme {
        ManagementScreen(navController = rememberNavController())
    }

}