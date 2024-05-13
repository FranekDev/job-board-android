package com.franekdev.jobboard.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.franekdev.jobboard.data.getJobOffersData
import com.franekdev.jobboard.models.JobOffer

class JobOfferViewModel : ViewModel() {
    private val _jobOffers = mutableStateOf(getJobOffersData())

    fun setJobOffers(offers: List<JobOffer>) {
        _jobOffers.value = offers
    }

    fun addJobOffer(offer: JobOffer) {
        _jobOffers.value += offer
    }

    fun getJobOfferById(id: Int): JobOffer {
        return _jobOffers.value.first { it.id == id}
    }

    fun getLastId(): Int {
        return _jobOffers.value.last().id
    }

    fun changeFavouriteStatus(id: Int) {
        val jobOffer = _jobOffers.value.first { it.id == id}
        jobOffer.isFavorite = !jobOffer.isFavorite
        _jobOffers.value.map { if (it.id == id) jobOffer else it }
    }

    fun getFavouriteOffers() = mutableStateOf(_jobOffers.value.filter { it.isFavorite })

    fun getJobOffers() = mutableStateOf(_jobOffers.value)

    fun getOffersIds() = mutableStateOf(_jobOffers.value.map { it.id })

    fun getOffersByFavourite() = mutableStateOf(_jobOffers.value.sortedByDescending { it.isFavorite })
}