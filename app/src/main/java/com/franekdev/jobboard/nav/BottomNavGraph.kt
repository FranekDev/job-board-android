package com.franekdev.jobboard.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.franekdev.jobboard.screens.FavouriteScreen
import com.franekdev.jobboard.screens.HomeScreen
import com.franekdev.jobboard.screens.JobOfferScreen
import com.franekdev.jobboard.screens.NewJobOfferScreen
import com.franekdev.jobboard.viewModels.JobOfferViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {

    val jobViewModel: JobOfferViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(
            route = BottomBarScreen.Home.route
        ) {
            val offers by jobViewModel.getOffersByFavourite()
            HomeScreen(
                jobOffers = offers,
                jobOfferViewModel = jobViewModel,
                navController = navController
            )
        }
        composable(
            route = BottomBarScreen.Favourite.route
        ) {
            val offers by jobViewModel.getFavouriteOffers()
            FavouriteScreen(
                jobOffers = offers,
                jobOfferViewModel = jobViewModel,
                navController = navController
            )
        }
        composable(route = BottomBarScreen.NewJobOffer.route) {
            NewJobOfferScreen(jobViewModel, navController)
        }
        composable(
            route = "${BottomBarScreen.JobOffer.route}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            ),
        ) {
            val id = it.arguments?.getString("id")?.toInt()

            if (id != null && id in jobViewModel.getOffersIds().value) {
                val jobOffer = id.let { offerId -> jobViewModel.getJobOfferById(offerId) }
                JobOfferScreen(jobOffer)
            } else {
                navController.popBackStack()
            }
        }

    }
}