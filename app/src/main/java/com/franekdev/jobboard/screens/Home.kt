package com.franekdev.jobboard.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.franekdev.jobboard.job.JobsList
import com.franekdev.jobboard.models.JobOffer
import com.franekdev.jobboard.viewModels.JobOfferViewModel

@Composable
fun HomeScreen(jobOffers: List<JobOffer>, jobOfferViewModel: JobOfferViewModel, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            JobsList(jobOffers, jobOfferViewModel, navController)
        }
    }
}
