package com.franekdev.jobboard.models

import kotlinx.serialization.Serializable

@Serializable
data class JobOffer(
    val id: Int,
    val title: String,
    val salary: String,
    val description: String,
    val localization: Localization,
    val company: Company,
    var isFavorite: Boolean = false
)
