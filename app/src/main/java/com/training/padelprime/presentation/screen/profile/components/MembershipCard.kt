package com.training.padelprime.presentation.screen.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.padelprime.R
import com.training.padelprime.presentation.screen.MembershipSection
import com.training.padelprime.ui.theme.PadelPrimeTheme
import com.training.padelprime.ui.theme.gray

@Composable
fun MembershipCard(modifier: Modifier = Modifier) {


    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(gray.copy(alpha = 0.10f))
            .width(200.dp)
            .height(100.dp)
            .clickable { }

    ){
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(horizontal = 14.dp)
        ) {
            Text(
                text ="5 Booking",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Text(
                text ="Save 250 SAR",
                fontWeight = FontWeight.Thin,
                fontSize = 10.sp
            )
        }

        Image(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(horizontal = 10.dp),
            painter = painterResource(id = R.drawable.ic_membership_type),
            contentDescription = null
        )

        Text(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 14.dp),
            text ="SAR 1500",
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp
        )

    }


}


@Preview
@Composable
private fun Prev() {
    PadelPrimeTheme {
        MembershipSection()
    }

}