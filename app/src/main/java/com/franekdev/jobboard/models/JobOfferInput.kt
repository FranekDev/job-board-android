package com.franekdev.jobboard.models

data class JobOfferInput(
    var jobTitle: String = "",
    var jobSalary: Int = 0,
    var jobDescription: String = "",
    var companyName: String = "",
    var companyAddress: String = "",
    var companyEmail: String = "",
    var companyPhoneNumber: String = "",
    var country: String = "",
    var city: String = "",
    var address: String = ""
)

fun JobOfferInput.all(): Boolean {
    return jobTitle.isNotEmpty() &&
            jobSalary > 0 &&
            jobDescription.isNotEmpty() &&
            companyName.isNotEmpty() &&
            companyAddress.isNotEmpty() &&
            companyEmail.isNotEmpty() &&
            companyPhoneNumber.isNotEmpty() &&
            country.isNotEmpty() &&
            city.isNotEmpty() &&
            address.isNotEmpty()
}

fun JobOfferInput.toJobOffer(): JobOffer {
    return JobOffer(
        id = 0,
        title = jobTitle,
        salary = jobSalary.toString(),
        description = jobDescription,
        company = Company(
            name = companyName,
            address = companyAddress,
            email = companyEmail,
            phoneNumber = companyPhoneNumber
        ),
        localization = Localization(
            country = country,
            city = city,
            address = address
        )
    )
}

fun JobOfferInput.reset() {
    jobTitle = ""
    jobSalary = 0
    jobDescription = ""
    companyName = ""
    companyAddress = ""
    companyEmail = ""
    companyPhoneNumber = ""
    country = ""
    city = ""
    address = ""
}
