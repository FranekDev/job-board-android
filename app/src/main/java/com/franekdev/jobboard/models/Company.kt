package com.franekdev.jobboard.models

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val name: String,
    val address: String,
    val email: String,
    val phoneNumber: String = "",
)
