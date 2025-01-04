package com.training.padelprime.presentation.screen

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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.training.padelprime.presentation.screen.profile.components.MembershipCard
import com.training.padelprime.ui.theme.PadelPrimeTheme
import com.training.padelprime.ui.theme.darkGray
import com.training.padelprime.ui.theme.gray
import com.training.padelprime.ui.theme.orange

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController,

    ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Padel X Profile", fontWeight = FontWeight.Light
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
        modifier = Modifier
            .padding(10.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Membership", fontWeight = FontWeight.Thin, fontSize = 18.sp)

            Text(
                text = "Add Package",
                fontWeight = FontWeight.Thin,
                fontSize = 14.sp,
                color = orange
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
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
            .padding(horizontal = 10.dp)
            .clip(RoundedCornerShape(4.dp)),
        colors = CardDefaults.cardColors(
            containerColor = gray.copy(alpha = 0.10f)
        )
    ) {

        var selectedBox by remember { mutableIntStateOf(1) }

        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { selectedBox = 1 }
                    .background(if (selectedBox == 1) gray.copy(alpha = 0.30f) else Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Court Details",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .clickable { selectedBox = 2 }
                    .background(if (selectedBox == 2) gray.copy(alpha = 0.30f) else Color.Transparent),

                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Posts",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    fontSize = 14.sp
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
            .padding(horizontal = 10.dp),
    ) {
        Text(text = "Club Coach", fontWeight = FontWeight.Medium, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(11.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.iv_add_coach),
                contentDescription = null,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .clickable { }
            )

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                repeat(10) { index ->
                    Image(
                        painter = painterResource(id = R.drawable.iv_coach),
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .clickable { }
                    )

                }
            }
        }
    }
}

@Composable
fun ButtonsSection() {

    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, orange, RoundedCornerShape(8.dp))
                .clickable { },
            colors = CardDefaults.cardColors(
                containerColor = gray.copy(alpha = 0.10f)
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize(),
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
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color.White,
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
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    colors = ButtonColors(
                        containerColor = orange,
                        contentColor = darkGray,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    ),
                    shape = RoundedCornerShape(6.dp),
                    onClick = { }
                ) {
                    Text(text = "Edit Profile")

                }
                Button(
                    modifier = Modifier
                        .fillMaxHeight()
                        .border(1.dp, orange, RoundedCornerShape(6.dp)),
                    colors = ButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = orange,
                        disabledContainerColor = Color.Unspecified,
                        disabledContentColor = Color.Unspecified
                    ),
                    shape = RoundedCornerShape(6.dp),
                    onClick = { }
                ) {
                    Text(text = "Add Court")
                }


            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(shape = RoundedCornerShape(6.dp))
                    .width(48.dp)
                    .background(darkGray)
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
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = R.drawable.iv_profile_cover),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 100.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.iv_profile_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)

                )

                Row(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .height(60.dp)
                        .padding(horizontal = 10.dp)
                        .offset(y = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    FollowersSection()
                }


            }

        }

        Spacer(modifier = Modifier.height(54.dp))

        Column(
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {
            Text(text = "Padel X", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(
                text = "i Play Padel 4 years ago, No one cant defeat me... ",
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
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
                    fontSize = 12.sp,
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
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "834", fontWeight = FontWeight.Light, fontSize = 14.sp)
        Text(text = "Followers", fontWeight = FontWeight.Light, fontSize = 10.sp)
    }

    VerticalDivider(
        color = gray.copy(alpha = 0.30f),
        thickness = 2.dp
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "834", fontWeight = FontWeight.Light, fontSize = 14.sp)
        Text(text = "Followers", fontWeight = FontWeight.Light, fontSize = 10.sp)
    }

    VerticalDivider(
        color = gray.copy(alpha = 0.30f),
        thickness = 2.dp
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "834", fontWeight = FontWeight.Light, fontSize = 14.sp)
        Text(text = "Followers", fontWeight = FontWeight.Light, fontSize = 10.sp)
    }

}


@PreviewLightDark
@Composable
private fun ProfileScreenPrev() {
    PadelPrimeTheme {
        ProfileScreen(navController = rememberNavController())
    }

}