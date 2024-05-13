package com.franekdev.jobboard.models

import kotlinx.serialization.Serializable

@Serializable
data class Localization(
    val country: String,
    val city: String,
    val address: String,
)
