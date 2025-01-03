package com.training.padelprime.presentation.screen.management

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.padelprime.R


@Composable
fun Calendar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "AUG 2024",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Previous month",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Next month",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF303234).copy(alpha = 0.70f))
                    .clickable(onClick = {})
                    .size(40.dp),  // Adjust size as needed
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .padding()
                )
            }


        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Color(0xFF303234).copy(alpha = 0.70f))
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach { day ->
                    Text(
                        text = day,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Calendar grid
            val days = listOf(
                (26..30).map { CalendarDay(it, false) } + // Previous month
                        (1..30).map { CalendarDay(it, true) }     // Current month
            ).flatten()

            GridCalendarDays(days = days)

        }
        // Weekday eaders

    }
}

@Composable
private fun GridCalendarDays(days: List<CalendarDay>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        days.chunked(7).forEach { weekDays ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                weekDays.forEach { day ->
                    DayCell(day = day)
                }
            }
        }
    }
}

@Composable
private fun DayCell(day: CalendarDay) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(if (day.date == 13 && day.isCurrentMonth) Color(0xFFFACC15) else Color.Transparent)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.date.toString(),
            color = when {
                day.date == 13 && day.isCurrentMonth -> Color.Black
                day.isCurrentMonth -> Color.White
                else -> Color.Gray
            },
            fontSize = 14.sp
        )
    }
}

data class CalendarDay(
    val date: Int,
    val isCurrentMonth: Boolean,
)

@Preview
@Composable
private fun Prev() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Calendar()
    }

}