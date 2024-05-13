package com.franekdev.jobboard.job

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.franekdev.jobboard.models.JobOffer
import com.franekdev.jobboard.nav.BottomBarScreen
import com.franekdev.jobboard.viewModels.JobOfferViewModel

@Composable
fun JobOfferView(
    jobOffer: JobOffer,
    navController: NavHostController? = null,
    onFavouriteClick: (JobOffer) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(14.dp, 5.dp, 14.dp, 12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = jobOffer.title, fontSize = 18.sp)
                FavouriteIconButton(jobOffer = jobOffer) {
                    onFavouriteClick(jobOffer)
                }
            }
            Text(text = jobOffer.salary, fontSize = 14.sp)
            Text(
                text = jobOffer.description,
                fontSize = 13.sp,
                lineHeight = 15.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 3.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Info",
                    modifier = Modifier
                        .size(13.dp)
                )
                Text(
                    text = "Details",
                    fontSize = 11.sp,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier
                        .padding(3.dp, 0.dp, 0.dp, 0.dp)
                        .clickable {
                        navController?.navigate("${BottomBarScreen.JobOffer.route}/${jobOffer.id}")
                    }
                )
            }
        }
    }
}

@Composable
fun JobsList(
    jobOffers: List<JobOffer>,
    jobOfferViewModel: JobOfferViewModel,
    navController: NavHostController
) {
    LazyColumn(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        modifier = Modifier.padding(10.dp),
    ) {
        items(jobOffers) {
            JobOfferView(it, navController) { offer ->
                jobOfferViewModel.changeFavouriteStatus(offer.id)
                navController.currentDestination?.route?.let { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                        anim {
                            enter = -1
                            exit = -1
                            popEnter = -1
                            popExit = -1
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FavouriteIconButton(jobOffer: JobOffer, onFavouriteClick: (JobOffer) -> Unit) {
    var refresh by remember { mutableStateOf(true) }

    if (refresh) {
        IconButton(
            onClick = {
                onFavouriteClick(jobOffer)
                refresh = false
                refresh = true
            },
        ) {
            if (jobOffer.isFavorite) {
                Icon(Icons.Filled.Favorite, contentDescription = "Favourite")
            } else {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favourite")
            }
        }
    }
}
