package com.training.padelprime.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.training.padelprime.R
import com.training.padelprime.presentation.screen.profile.components.MembershipCard
import com.training.padelprime.ui.theme.PadelPrimeTheme
import com.training.padelprime.ui.theme.darkGray
import com.training.padelprime.ui.theme.darkOrange
import com.training.padelprime.ui.theme.gray
import com.training.padelprime.ui.theme.white
import com.training.padelprime.ui.theme.yellow

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController,

    ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ,

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Padel X Profile", fontWeight = FontWeight.Normal
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
            )
        }


        ProfileDetailsSection()

        Spacer(modifier = Modifier.height(10.dp))

        ButtonsSection()

        Spacer(modifier = Modifier.height(10.dp))


        ClubCoachSection()

        Spacer(modifier = Modifier.height(24.dp))


        CourtDetailsAndPostsSection()

        Spacer(modifier = Modifier.height(14.dp))


        MembershipSection()



    }


}

@Composable
fun MembershipSection() {
    Column(
        modifier = Modifier.padding(bottom = 80.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "Membership",
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                color = white
            )

            Text(
                text = "Add Package",
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                color = darkOrange
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()),
        ) {
            repeat(3) { index ->
                MembershipCard()
            }
        }

    }
}

@Composable
fun CourtDetailsAndPostsSection() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 10.dp)
            .clip(RoundedCornerShape(8.dp)), colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.04f)
        )
    ) {

        var selectedBox by remember { mutableIntStateOf(1) }

        val textBackgroundColorBox1 = if (selectedBox == 1) Color.White.copy(alpha = 0.10f) else Color.Transparent
        val textColorBox1 = if (selectedBox == 1) white else Color(0xFF7A7A7A)

        val textBackgroundColorBox2 = if (selectedBox == 2) Color.White.copy(alpha = 0.10f) else Color.Transparent
        val textColorBox2 = if (selectedBox == 2) white else Color(0xFF7A7A7A)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .clickable { selectedBox = 1 }
                .background(textBackgroundColorBox1),
                contentAlignment = Alignment.Center) {
                Text(
                    text = "Court Details",
                    fontWeight = FontWeight.Medium,
                    color = textColorBox1,
                    fontSize = 14.sp
                )
            }

            Box(modifier = Modifier
                .weight(1f)
                .padding(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .clickable { selectedBox = 2 }
                .background(textBackgroundColorBox2),

                contentAlignment = Alignment.Center) {
                Text(
                    text = "Posts", fontWeight = FontWeight.Medium, color = textColorBox2, fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun ClubCoachSection() {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 31.dp),
        verticalArrangement = Arrangement.spacedBy(11.dp)
    ) {
        Text(
            text = "Club Coach", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = white
        )

        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.iv_add_coach),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .clickable { })
                Text(
                    text = "New", fontWeight = FontWeight.Normal, fontSize = 12.sp, color = white
                )

            }

            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                repeat(10) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.iv_coach),
                            contentDescription = null,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .border(BorderStroke(1.dp, white), CircleShape)
                                .clickable { }
                                .padding(4.dp)
                        )

                        Text(
                            text = "Wade Warren",
                            fontWeight = FontWeight.Normal,
                            fontSize = 10.sp,
                            color = white
                        )


                    }


                }
            }
        }
    }
}

@Composable
fun ButtonsSection() {

    Column(
        modifier = Modifier.padding(horizontal = 14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, darkOrange, RoundedCornerShape(8.dp))
                .clickable { },
            colors = CardDefaults.cardColors(
                containerColor = white.copy(alpha = 0.05f)
            )
        ) {

            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Dashboard",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Row {

                    Text(
                        text = "5k Revenue in the last 30 days",
                        fontWeight = FontWeight.Thin,
                        color = Color.Gray,
                        fontSize = 9.sp,
                    )

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = white,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }

            }


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFFF2AD25), Color(0xFFB97C03)
                            )
                        ), shape = RoundedCornerShape(6.dp)
                    ), colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = darkGray,
                ), shape = RoundedCornerShape(6.dp), onClick = { }) {
                    Text(text = "Edit Profile")
                }
                Button(modifier = Modifier
                    .fillMaxHeight()
                    .border(1.dp, darkOrange, RoundedCornerShape(6.dp)), colors = ButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = darkOrange,
                    disabledContainerColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified
                ), shape = RoundedCornerShape(6.dp), onClick = { }) {
                    Text(text = "Add Court")
                }


            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(6.dp))
                    .width(48.dp)
                    .background(white.copy(alpha = 0.10f))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_profile),
                    contentDescription = null,
                    tint = Color.Gray
                )

            }


        }


    }


}

@Composable
fun ProfileDetailsSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {

        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.iv_profile_cover),
                contentDescription = null,
                modifier = Modifier
                    .height(175.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 118.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.iv_profile_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(110.dp)
                        .padding(horizontal = 10.dp)
                )

                Row(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .height(60.dp)
                        .padding(horizontal = 15.dp)
                        .offset(y = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    FollowersSection()
                }


            }

        }

        Spacer(modifier = Modifier.height(48.dp))

        Column(
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {
            Text(
                text = "Padel X", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = white
            )
            Text(
                text = "i Play Padel 4 years ago, No one cant defeat me... ",
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                lineHeight = 17.sp,
                color = white
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Jeddah, Saudi Arabia",
                    fontWeight = FontWeight.Thin,
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            }


        }

    }
}

@Composable
fun FollowersSection() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-6).dp)
    ) {
        Text(text = "834", fontWeight = FontWeight.Medium, fontSize = 12.sp, color = white)
        Text(
            text = "Followers", fontWeight = FontWeight.Normal, fontSize = 10.sp, color = white
        )
    }


    VerticalDivider(
        modifier = Modifier.padding(vertical = 10.dp),
        color = gray.copy(alpha = 0.10f),
        thickness = 2.dp
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-6).dp)
    ) {
        Text(text = "162", fontWeight = FontWeight.Medium, fontSize = 12.sp, color = white)
        Text(
            text = "Following", fontWeight = FontWeight.Normal, fontSize = 10.sp, color = white
        )
    }


    VerticalDivider(
        modifier = Modifier.padding(vertical = 10.dp),
        color = gray.copy(alpha = 0.10f),
        thickness = 2.dp
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy((-6).dp)
    ) {
        Text(
            text = "15", fontWeight = FontWeight.Medium, fontSize = 12.sp, color = white
        )
        Text(text = "Activates", fontWeight = FontWeight.Normal, fontSize = 10.sp, color = yellow)
    }

}


@PreviewLightDark
@Composable
private fun ProfileScreenPrev() {
    PadelPrimeTheme {
        ProfileScreen(navController = rememberNavController())
    }

}