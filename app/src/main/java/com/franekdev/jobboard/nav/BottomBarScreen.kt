package com.franekdev.jobboard.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val image: ImageVector
) {
    data object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        image = Icons.Default.Home
    )

    data object Favourite : BottomBarScreen(
        route = "favourite",
        title = "Favourite",
        image = Icons.Default.Star
    )

    data object NewJobOffer : BottomBarScreen(
        route = "newJobOffer",
        title = "New Job Offer",
        image = Icons.Default.Add
    )

    data object JobOffer : BottomBarScreen(
        route = "jobOffer",
        title = "Job Offer",
        image = Icons.Default.Info
    )

}