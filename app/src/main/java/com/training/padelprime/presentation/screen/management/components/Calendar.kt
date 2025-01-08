package com.training.padelprime.presentation.screen.management.components

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.padelprime.R
import com.training.padelprime.ui.theme.darkGray
import com.training.padelprime.ui.theme.white
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
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
                    fontWeight = FontWeight.SemiBold,
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_up),
                    contentDescription = "Previous month",
                    tint = white,
                    modifier = Modifier.size(26.dp)
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "Next month",
                    tint = white,
                    modifier = Modifier.size(26.dp)
                )

            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.20f))
                    .clickable(onClick = {})
                    .size(44.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .padding()
                )
            }


        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .background(white.copy(alpha = 0.10f))
                .padding(16.dp)

        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat").forEach { day ->
                    Text(
                        text = day,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))


            val days = listOf(
                (26..30).map { CalendarDay(it, false) } +
                        (1..30).map { CalendarDay(it, true) }
            ).flatten()

            GridCalendarDays(days = days)

        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
private fun GridCalendarDays(days: List<CalendarDay>) {
    val today = LocalDate.now()
    var selectedDay by remember { mutableStateOf(days.find { it.date == today.dayOfMonth && it.isCurrentMonth }) }


    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        days.chunked(7).forEach { weekDays ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                weekDays.forEach { day ->
                    DayCell(
                        day = day,
                        isSelected = day == selectedDay,
                        onClick = { selectedDay = day }
                    )
                }
            }
        }
    }
}

@Composable
private fun DayCell(
    day: CalendarDay,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(
                if (isSelected) {
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFCF8F11),
                            Color(0xFFFDD42E)
                        )
                    )
                } else {
                    Brush.linearGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent
                        )
                    )
                }
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.date.toString(),
            color = if (isSelected) darkGray else if (day.isCurrentMonth) Color.White else Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
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