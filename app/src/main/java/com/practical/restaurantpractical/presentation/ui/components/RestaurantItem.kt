package com.practical.restaurantpractical.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.practical.restaurantpractical.domain.model.Result
import com.practical.restaurantpractical.presentation.ui.theme.Orange

@Composable
fun RestaurantItem(data: Result?) {
    Column {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Box(modifier = Modifier
                .height(110.dp)){
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    painter = rememberAsyncImagePainter(data?.icon_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .height(20.dp)
                        .clip(shape = RoundedCornerShape(8.dp))
                        .background(color = Color.White)
                        .align(alignment = Alignment.BottomCenter).padding(horizontal = 5.dp),
                ) {
                    Row {
                        Image(
                            imageVector = Icons.Default.Star,
                            contentDescription = null, // Set the content description if needed
                            modifier = Modifier.size(24.dp),
                            colorFilter = ColorFilter.tint(color = Orange)
                        )

                        Text(text = data?.rating.toString())
                    }

                }
            }
           Column {
               Text(text = data!!.slug, fontSize = 16.sp, fontWeight = FontWeight.Bold)
               Text(text = data.delivery_time!!, color = Color.Gray)
               Text(text = data.two_person_price!!,fontSize = 16.sp, fontWeight = FontWeight.Bold)
           }
        }
    }
}


